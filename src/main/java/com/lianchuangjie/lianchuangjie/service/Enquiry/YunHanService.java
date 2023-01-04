package com.lianchuangjie.lianchuangjie.service.Enquiry;

public interface YunHanService {
    /**
     * @return Boolean
     * @description 给采购分发询价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/30/2022
     */
    Boolean runSendToBuyer(Long docEntry);
    Boolean yunHanQuery(Long docEntry);
}
