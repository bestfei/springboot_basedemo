package com.bestfei.springboot_basedemo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Account {

    private long id;
    private String accountName;
    private String password;
    private String mobile;
}
