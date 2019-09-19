package com.bestfei.springboot_basedemo.controller;

import com.bestfei.springboot_basedemo.common.enumer.ResponseCodeEnum;
import com.bestfei.springboot_basedemo.common.exception.UserException;
import com.bestfei.springboot_basedemo.dto.Account;
import com.bestfei.springboot_basedemo.dto.ApiResponse;
import com.bestfei.springboot_basedemo.dto.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@RestController注解能够使项目支持Rest
@RestController
@Slf4j
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/apitest")
public class ApiRequestController {

    @RequestMapping(value = "/requestget", method = RequestMethod.GET)
    public String getUserByGet(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }

    @RequestMapping(value = "/requestpostform", method = RequestMethod.POST)
    public String getUserByPostForm(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }

    //在入参设置@RequestBody注解表示接收整个报文体，这里主要用在接收整个POST请求中的json报文体，
    @RequestMapping(value = "/requestpostjson",method = RequestMethod.POST)
    public ApiResponse getUserByPostJson(@Valid @RequestBody LoginRequest loginRequest){
        ApiResponse response = new ApiResponse();
        try{
            if(loginRequest.getLoginAccount().isEmpty())
                throw new UserException("please input your login account");
            if(loginRequest.getPassword().isEmpty())
                throw new UserException("please input your login password");

            Account account = new Account();
            account.setId(1l);
            account.setAccountName(loginRequest.getLoginAccount());
            account.setPassword(loginRequest.getPassword());
            account.setMobile("96662055743");
            response.setCode(ResponseCodeEnum.Success.getErrorCode());
            response.setMsg("success");
            response.setData(account);
        }
        catch (UserException e){
            log.error(e.getMessage());
            response.setCode(ResponseCodeEnum.AccountError.getErrorCode());
            response.setMsg(e.getMessage());
        }
        catch (Exception e){
            log.error(e.getMessage());
            response.setCode(ResponseCodeEnum.SystemError.getErrorCode());
            response.setMsg("system error");
        }
        return response;
    }

}
