package com.healthelp.zull.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class PostElapsedTimeFilter extends ZuulFilter {


    private static Logger log = LoggerFactory.getLogger(PostElapsedTimeFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        log.info(" -- ZULL - PRO");
        Long timeStart = (Long) httpServletRequest.getAttribute("timeStart");
        Long timeEnd = System.currentTimeMillis();
        Long elapsedTime = timeEnd-timeStart;
        log.info(" -- ZULL - Elapsed Time sg: {} ",(elapsedTime).doubleValue()/1000.00);
        log.info(" -- ZULL - Elapsed Time ms: {} ",(elapsedTime));
        return null;
    }
}
