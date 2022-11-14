package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomMainSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomMainEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomMainVO;

public interface BomMainService extends IService<BomMainEntity> {
    Page<BomMainVO> list(BomMainSearchDTO bomMainSearchDTO);
}
