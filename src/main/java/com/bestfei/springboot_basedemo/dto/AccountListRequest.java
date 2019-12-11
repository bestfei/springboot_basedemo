package com.bestfei.springboot_basedemo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class AccountListRequest {

    private List<AccountDto> data;
}
