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

    @Autowired
    AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/apitest/requestget").excludePathPatterns("/apitest/requestpostform").excludePathPatterns("/error");
    }




}
