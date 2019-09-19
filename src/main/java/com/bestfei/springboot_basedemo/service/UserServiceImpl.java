package com.bestfei.springboot_basedemo.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getMobile(){
        return "dd";
    }

    @Override
    public String getUserDetail(String username){
        return "dd";
    }
}
