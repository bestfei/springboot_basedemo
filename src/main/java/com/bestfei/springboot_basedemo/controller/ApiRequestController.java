package com.bestfei.springboot_basedemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.bestfei.springboot_basedemo.common.enumer.ResponseCodeEnum;
import com.bestfei.springboot_basedemo.common.exception.HeadException;
import com.bestfei.springboot_basedemo.common.exception.UserException;
import com.bestfei.springboot_basedemo.dto.AccountDetail;
import com.bestfei.springboot_basedemo.dto.AccountDto;
import com.bestfei.springboot_basedemo.dto.ApiResponse;
import com.bestfei.springboot_basedemo.dto.LoginRequest;
import com.bestfei.springboot_basedemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//@RestController注解能够使项目支持Rest
@RestController
@Slf4j
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/apitest")
public class ApiRequestController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/requestget", method = RequestMethod.GET)
    public String getUserByGet(HttpServletRequest httpServletRequest,@RequestParam(value = "userName") String userName){
        String token = httpServletRequest.getHeader("token");
        return "Hello " + userName + ",tocken:"+token;
    }

    @RequestMapping(value = "/requestpostform", method = RequestMethod.POST)
    public String getUserByPostForm(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }

    //在入参设置@RequestBody注解表示接收整个报文体，这里主要用在接收整个POST请求中的json报文体，
    @RequestMapping(value = "/requestpostjson",method = RequestMethod.POST)
    public ApiResponse getUserByPostJson( HttpServletResponse httpServletResponse, @Valid @RequestBody LoginRequest loginRequest){
        ApiResponse response = new ApiResponse();
        try{
            if(loginRequest.getLoginAccount().isEmpty())
                throw new UserException("please input your login account");
            if(loginRequest.getPassword().isEmpty())
                throw new UserException("please input your login password");

            AccountDto accountDto = new AccountDto();
            accountDto.setId(1l);
            accountDto.setAccountName(loginRequest.getLoginAccount());
            accountDto.setPassword(loginRequest.getPassword());
            accountDto.setMobile(userService.getMobile());
            response.setCode(ResponseCodeEnum.Success.getErrorCode());
            response.setMsg("success");
            response.setData(accountDto);
        }
        catch (UserException e){
            log.error(e.getMessage());
            //修改http code的值
            //httpServletResponse.setStatus(501);
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


    @RequestMapping(value = "/getAccountDetail",method = RequestMethod.POST)
    public ApiResponse getUserByPostJson( HttpServletResponse httpServletResponse, @Valid @RequestBody AccountDto accountDto){
        ApiResponse response = new ApiResponse();
        try {
            JSONObject headerUserAgent = JSONObject.parseObject(request.getHeader("User-Agent"));
            AccountDetail accountDetail = new AccountDetail();
            if(!headerUserAgent.containsKey("id"))
                throw new HeadException("header User-Agent is null");
            accountDetail.setAccountId(headerUserAgent.getLong("id"));
            accountDetail.setAccountName(accountDto.getAccountName());
            accountDetail.setMobile("9662955743");
            accountDetail.setAddress("16th Floor World Plaza Building, 30th St. corner 5th Avenue,BGC, Taguig City, Philippines");
            List<String> cards = new ArrayList<String>();
            cards.add("1234567890");cards.add("1234512345");cards.add("5432167890");
            accountDetail.setCards(cards);
            response.setCode(ResponseCodeEnum.Success.getErrorCode());
            response.setMsg("success");
            response.setData(accountDetail);
        }
        catch (HeadException e){
            log.error(e.getMessage());
            //修改http code的值
            //httpServletResponse.setStatus(501);
            response.setCode(ResponseCodeEnum.HeaderError.getErrorCode());
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
