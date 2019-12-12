package com.bestfei.springboot_basedemo.service;

import com.bestfei.springboot_basedemo.dto.AccountDto;
import com.bestfei.springboot_basedemo.dto.AccountListRequest;
import com.bestfei.springboot_basedemo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public String getMobile(){
        return "9662055001";
    }

    @Override
    public String getUserDetail(String username){
        return "dd";
    }

    @Override
    public int collectAccountList(AccountListRequest data){
        List<AccountDto> accountDtoList = data.getData();
        for(int i=0;i<accountDtoList.size();i++){
            System.out.println("accountName:"+accountDtoList.get(i).getAccountName()+",mobile:"+accountDtoList.get(i).getMobile());
        }
        return accountDtoList.size();
    }

    @Override
    public int insert(AccountDto accountDto){
        return accountMapper.insert(accountDto);
    }

    @Override
    public AccountDto selectByPrimaryKey(Long id){
        return accountMapper.selectByPrimaryKey(id);
    }


}
