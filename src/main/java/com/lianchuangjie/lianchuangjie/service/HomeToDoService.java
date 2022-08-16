package com.lianchuangjie.lianchuangjie.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface HomeToDoService {
    /**
     * @description 获取待处理询价单、报价单数量
     */
    Map<String, Long> getToDoNum(HttpServletRequest request);
}
