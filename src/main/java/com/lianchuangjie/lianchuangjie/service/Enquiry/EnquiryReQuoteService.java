package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.EnquiryReQuoteDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;

public interface EnquiryReQuoteService extends IService<EnquirySubEntity> {
    /**
     * @param enquiryReQuoteDTO enquiryReQuoteDTO
     * @return Boolean
     * @description 销售给采购发一个待确认的询价
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/22/2022
     */
    Boolean handle(EnquiryReQuoteDTO enquiryReQuoteDTO);
}