package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;

import java.util.List;

public interface EnquirySubService extends IService<EnquirySubEntity> {
    List<EnquirySubVO> getListService(Long docEntry);
}
