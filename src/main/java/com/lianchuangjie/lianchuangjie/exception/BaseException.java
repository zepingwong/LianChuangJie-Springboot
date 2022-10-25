package com.lianchuangjie.lianchuangjie.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @description spring 对于 RuntimeException 异常才会进行事务回滚，所以这里的BaseException 继承 RuntimeException
 * @author WANG Zeping
 * @email zepingwong@gmail.com
 * @date 2022/06/03
 */
@Getter
@Setter
@Slf4j
public class BaseException extends RuntimeException{
    protected IResponseEnum responseEnum;
    protected Object[] args;
    public BaseException(IResponseEnum responseEnum){
        super(responseEnum.getMessage());
        this.responseEnum=responseEnum;
    }
    public BaseException(int code,String msg){
        super(msg);
        this.responseEnum=new IResponseEnum() {
            @Override
            public int getCode() {
                return code;
            }
            @Override
            public String getMessage() {
                return msg;
            }
        };
        log.error(msg);
    }
    public BaseException(IResponseEnum responseEnum,Object[] args,String message){
        super(message);
        this.responseEnum=responseEnum;
        this.args=args;
    }
    public BaseException(IResponseEnum responseEnum,Object[] args,String message,Throwable cause){
        super(message,cause);
        this.responseEnum=responseEnum;
        this.args=args;
    }
}
