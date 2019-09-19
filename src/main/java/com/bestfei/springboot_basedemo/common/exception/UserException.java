package com.bestfei.springboot_basedemo.common.exception;

public class UserException extends RuntimeException{
    public UserException(String message){
        super(message);
    }
}
