package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryIsOrderedDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;

public interface EnquiryIsOrderedService extends IService<EnquirySubEntity> {
    /**
     * @param enquiryIsOrderedDTO enquiryIsOrderedDTO
     * @return Boolean
     * @description 下单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/22/2022
     */
    Boolean handle(EnquiryIsOrderedDTO enquiryIsOrderedDTO);
}
