package com.bestfei.springboot_basedemo.common.enumer;

public enum ResponseCodeEnum {

    Success(0),
    SystemError(9999), AccountError(9901);

    private int errorCode;
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    ResponseCodeEnum(int errorCode){
        this.errorCode = errorCode;
    }
}
