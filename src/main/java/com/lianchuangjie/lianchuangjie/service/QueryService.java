package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySingleQueryDTO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;

import java.util.List;

public interface QueryService {
    /**
     * @param enquirySingleQueryDTO singleQueryDTO
     * @return List
     * @description 关联型号匹配
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    List<BomQueryItemVO> queryRelated(EnquirySingleQueryDTO enquirySingleQueryDTO);
}
