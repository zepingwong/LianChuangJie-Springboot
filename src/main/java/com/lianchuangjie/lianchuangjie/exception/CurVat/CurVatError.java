package com.lianchuangjie.lianchuangjie.exception.CurVat;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CurVatError implements CurVatExceptionAssert {
    DUPLICATION(1, "改配置已存在"),
    SAVE_ERROR(1, "保存失败"),;
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
