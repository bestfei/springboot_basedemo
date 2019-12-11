package com.bestfei.springboot_basedemo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AccountDetail {

    private long accountId;
    private String accountName;
    private String mobile;
    private String address;
    private List<String> cards;

}
