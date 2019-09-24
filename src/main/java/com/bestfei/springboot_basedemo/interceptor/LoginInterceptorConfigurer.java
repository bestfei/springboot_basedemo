package com.bestfei.springboot_basedemo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
@Slf4j
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Autowired
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(securityInterceptor).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/signup").excludePathPatterns("/error");
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
    }




}
