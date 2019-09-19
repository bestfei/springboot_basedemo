package com.bestfei.springboot_basedemo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class LoginRequest {

    @NotNull(message = "login account can not be blank")
    private String loginAccount;
    @NotNull(message = "password can not be blank")
    private String password;

    private String otpcode;
}
