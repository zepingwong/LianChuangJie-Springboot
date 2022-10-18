package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.EnquirySaveItemDTO;
import com.lianchuangjie.lianchuangjie.dto.search.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquirySubVO;

import java.util.List;

public interface EnquirySubService extends IService<EnquirySubEntity> {
    /**
     * @param searchCondition searchCondition
     * @return List
     * @description 获取询价单子表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    Page<EnquirySubVO> list(EnquirySubSearchDTO searchCondition);
    Boolean save(List<EnquirySaveItemDTO> list);
    Boolean saveOne(EnquirySaveItemDTO enquirySaveItemDTO);
}
