package com.bestfei.springboot_basedemo.service;

import com.bestfei.springboot_basedemo.dto.AccountDto;
import com.bestfei.springboot_basedemo.dto.AccountListRequest;

public interface UserService {

    int insert(AccountDto accountDto);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(AccountDto accountDto);

    AccountDto selectByPrimaryKey(Long id);

    String getMobile();

    String getUserDetail(String username);

    int collectAccountList(AccountListRequest data);

}
