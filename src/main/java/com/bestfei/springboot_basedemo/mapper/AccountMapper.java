package com.bestfei.springboot_basedemo.mapper;

import com.bestfei.springboot_basedemo.dto.AccountDto;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

    @Insert({
            "insert into account (`accountName`, `password`, `mobile`) ",
            "values (#{accountName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR})"
    })
    int insert(AccountDto accountDto);
}
