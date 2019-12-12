package com.bestfei.springboot_basedemo.mapper;

import com.bestfei.springboot_basedemo.dto.AccountDto;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

    @Insert({
            "insert into account (`accountName`, `password`, `mobile`) ",
            "values (#{accountName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR})"
    })
    int insert(AccountDto accountDto);

    @Delete({
            "delete from account",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Select({
            "select",
            //"id, createdAt, updatedAt, accountName, password, mobile ",
            "id, accountName, password, mobile ",
            "from account",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            //@Result(column="createdAt", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
            //@Result(column="updatedAt", property="updateAt", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="accountName", property="accountName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR)
    })
    AccountDto selectByPrimaryKey(Long id);
}
