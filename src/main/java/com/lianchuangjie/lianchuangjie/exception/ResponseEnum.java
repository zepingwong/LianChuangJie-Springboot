package com.lianchuangjie.lianchuangjie.exception;

import lombok.AllArgsConstructor;

/**
 * @author WANG Zeping
 * @email zepingwong@gmail.com
 * @date 2022/06/03
 * @description 返回信息对象中用到的枚举类
 */

@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert {

    SUCCESS(0,"成功"),
    FAILURE(500,"错误"),
    PASSWORD_ERROR(8002,"{0}"),
    ISNULL(8001, "{0}"),
    // 数据重复
    DATA_DUPLICATION_ERROR(516, "{0}"),
    // token 错误
    TOKEN_ERROR(401,"token 无效{0}"),
    TOKEN_ISNULL(401, "令牌为空{0}"),
    TOKEN_SIGNATURE(401, "无效签名{0}"),
    TOKEN_EXPIRED(401, "token 过期{0}"),
    SESSION_EXPIRED(408, "Session 已过期，请重新登录"),
    TOKEN_ALGORITHM_MISMATCH(401, "算法不一致{0}"),
    // authentication 权限错误
    HAS_NO_AUTHENTICATION(403, "权限错误.{0}"),
    // 下载失败
    DOWNLOAD_ERROR(1, "下载失败"),
    VALID_ERROR(8000, "{0}"),
    UPLOAD_ERROR(2, "上传错误")
    ;
    private final Integer code;
    private final String message;
    @Override
    public int getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
