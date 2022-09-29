package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.vo.EnquiryExportDataVO;

public interface EnquiryExportService {
    /**
     * @param docEntry docEntry
     * @return EnquiryExportDataVO
     * @description 输出标准报价单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    EnquiryExportDataVO list(Long docEntry);
}
