package com.healthelp.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class PreElapsedTimeFilter extends ZuulFilter {


    private static Logger log = LoggerFactory.getLogger(PreElapsedTimeFilter.class);

    @Override
    public String filterType() {
        return "pre";
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
        log.info(" -- ZULL - PRE {} Request routing to {}",httpServletRequest.getMethod(),httpServletRequest.getRequestURL().toString());
        Long timeStart = System.currentTimeMillis();
        httpServletRequest.setAttribute("timeStart",timeStart);
        return null;
    }
}
