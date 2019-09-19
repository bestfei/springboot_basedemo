package com.bestfei.springboot_basedemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController注解能够使项目支持Rest
@RestController
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/apitest")
public class ApiRequestController {

    @RequestMapping(value = "/requestget", method = RequestMethod.GET)
    String getUserByGet(@RequestParam(value = "userName") String userName){
        return "Hello， " + userName;
    }

}