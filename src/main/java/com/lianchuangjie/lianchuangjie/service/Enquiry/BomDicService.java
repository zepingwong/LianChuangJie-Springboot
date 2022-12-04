package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomHeadDicDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomHeadDictSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomHeadDicEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomHeadDictVO;

import java.util.List;

public interface BomDicService extends IService<BomHeadDicEntity> {
    List<String> getModleNameList();
    List<String> getBrandNameList();
    List<String> getRemarkNameList();
    List<String> getQuantityNameList();

    Page<BomHeadDictVO> getList(BomHeadDictSearchDTO bomHeadDictSearchDTO);
    boolean add(BomHeadDicDTO bomHeadDicDTO);
    boolean save(BomHeadDicDTO bomHeadDicDTO);
}
