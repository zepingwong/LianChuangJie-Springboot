package com.lianchuangjie.lianchuangjie.utils;

import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Result() {
    }
    public Result(T data) {
        this.data = data;
    }
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(ResponseEnum.SUCCESS.getCode());
        result.setMsg("成功");
        return result;
    }
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setCode(ResponseEnum.SUCCESS.getCode());
        result.setMsg("成功");
        return result;
    }
    public static <T> Result<T> success(T data,String msg) {
        Result<T> result = new Result<>(data);
        result.setCode(ResponseEnum.SUCCESS.getCode());
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
