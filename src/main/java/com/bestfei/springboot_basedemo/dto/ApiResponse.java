package com.bestfei.springboot_basedemo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ApiResponse {

    private int code;
    private String msg;
    private Object data;

}
