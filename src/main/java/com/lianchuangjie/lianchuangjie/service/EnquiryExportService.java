package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.vo.EnquiryExportDataVO;

public interface EnquiryExportService {
    /**
     * @param docEntry 文档编号
     * @return Boolean
     * @description 标准报价单
     */
    EnquiryExportDataVO export(Long docEntry);
}
