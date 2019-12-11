package com.bestfei.springboot_basedemo.service;

import com.bestfei.springboot_basedemo.dto.AccountListRequest;

public interface UserService {

    String getMobile();

    String getUserDetail(String username);

    int collectAccountList(AccountListRequest data);

}
