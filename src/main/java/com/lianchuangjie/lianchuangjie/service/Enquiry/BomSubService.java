package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryBomUpdateDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomSubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomExportVO;

import java.util.List;

public interface BomSubService extends IService<BomSubEntity> {
    /**
     * @param enquiryBomUpdateDTO enquiryBomUpdateDTO
     * @return Boolean
     * @description 更新Bom单一行
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/6/2022
     */
    Boolean updateOne(EnquiryBomUpdateDTO enquiryBomUpdateDTO);
    List<BomExportVO> export(Long docEntry);
}
