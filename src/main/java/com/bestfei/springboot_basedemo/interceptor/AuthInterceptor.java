package com.bestfei.springboot_basedemo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(!request.getRequestURI().contains("error")){
            log.info("request begin ==> [{}]",uri);
        }
        if(request.getRequestURI().equals("/intercept")){
            log.info("[{}] intercepted",uri);
            // 只有返回true才会继续向下执行，返回false取消当前请求
            return false;
        }
        // 转去error页面
        if(request.getRequestURI().equals("/intercept2")){
            log.info("[{}] intercepted",uri);
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
        if(!request.getRequestURI().contains("error")){
            log.info("request end ==> [{}]-[res status is: {}]",uri,String.valueOf(response.getStatus()));
        }
        super.afterCompletion(request, response, handler, ex);
    }



}
