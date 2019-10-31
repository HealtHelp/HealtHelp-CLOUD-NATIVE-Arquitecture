package com.healthelp.users.boot.timer;

import com.healthelp.users.controller.impl.UserControllerImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;



@Aspect
@Component
public class TimerExecution {

    private static final Logger log = LoggerFactory.getLogger(UserControllerImpl.class);

    @Around("execution(* com.healthelp.users.controller..*(..)))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        log.info(" -- Execution time of " + className + " - " + methodName + " : " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }
}
