package com.bestfei.springboot_basedemo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String realIP = realIP(request);
        if(!request.getRequestURI().contains("error")){
            log.info("request begin ==> [{}]-[{}]",realIP,uri);
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String uri = request.getRequestURI();
        String realIP = realIP(request);
        if(!request.getRequestURI().contains("error")){
            log.info("request end ==> [{}]-[{}]-[res status is: {}]",realIP,uri,String.valueOf(response.getStatus()));
        }
        super.afterCompletion(request, response, handler, ex);
    }

    public static String realIP(HttpServletRequest request) {
        String xff = request.getHeader("x-forwarded-for");
        if (xff != null) {
            int index = xff.indexOf(',');
            if (index != -1) {
                xff = xff.substring(0, index);
            }
            return xff.trim();
        }
        return request.getRemoteAddr();
    }

}
