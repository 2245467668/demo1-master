package com.example.demo.util;

import lombok.Getter;

@Getter
public class CommonResult {
    private Integer code;
    private String message;
    private Object data;

    public CommonResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static CommonResult nohandler() {
        return new CommonResult(ResultCode.NOHANDLER.getCode(), ResultCode.NOHANDLER.getMessage(),null);
    }
    public static CommonResult success(Object data) {
        return new CommonResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),data);
    }
    public static CommonResult failed() {
        return new CommonResult(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(),null);
    }
    public static CommonResult failed(String message) {
        return new CommonResult(ResultCode.FAILED.getCode(),message,null);
    }
    public static CommonResult notoken() {
        return new CommonResult(ResultCode.NOTOKEN.getCode(), ResultCode.NOTOKEN.getMessage(),null);
    }
    public static CommonResult nopremiss() {
        return new CommonResult(ResultCode.NOPERMISS.getCode(), ResultCode.NOPERMISS.getMessage(),null);
    }
}
