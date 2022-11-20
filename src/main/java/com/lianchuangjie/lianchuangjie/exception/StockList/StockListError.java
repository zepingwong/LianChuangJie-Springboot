package com.lianchuangjie.lianchuangjie.exception.StockList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StockListError implements StockListExceptionAssert {
    ISNULL(8001, "{0}");

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
