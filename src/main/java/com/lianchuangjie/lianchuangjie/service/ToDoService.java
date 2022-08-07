package com.lianchuangjie.lianchuangjie.service;

import java.util.Map;

public interface ToDoService {
    /**
     * @description 获取待处理询价单、报价单数量
     */
    Map<String, Long> getTodoNum(Long userSign);
}
