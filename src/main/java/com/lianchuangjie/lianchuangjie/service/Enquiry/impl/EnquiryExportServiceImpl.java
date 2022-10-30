package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryExportService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportDataVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportHeadVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnquiryExportServiceImpl implements EnquiryExportService {
    @Resource
    EnquiryMainMapper enquiryMainMapper;
    @Resource
    EnquirySubMapper enquirySubMapper;

    @Override
    public EnquiryExportDataVO list(Long docEntry) {
        EnquiryMainEntity enquiryMainEntity = enquiryMainMapper.selectByDocEntry(docEntry, SessionUtil.getUser().getUserSign());
        /*
         * 1. 报价单导出次数 +1
         * 2. 要判断报价单导出次数是否为 null
         */
        Integer state;
        if (enquiryMainEntity.getUState() == null) {
            state = 0;
        } else {
            state = enquiryMainEntity.getUState();
        }
        enquiryMainEntity.setUState(state + 1);
        // 导出数据
        EnquiryExportDataVO enquiryExportDataVO = new EnquiryExportDataVO();
        // 查询条件
        EnquirySubSearchDTO enquirySubSearchDTO = new EnquirySubSearchDTO();
        enquirySubSearchDTO.setDocEntry(docEntry);
        enquirySubSearchDTO.setOwnerCode(SessionUtil.getUser().getUserSign());
        // 表头
        EnquiryExportHeadVO enquiryExportHeadVO = enquirySubMapper.head(enquirySubSearchDTO);
        enquiryExportHeadVO.setSubject("报价");
        enquiryExportDataVO.setEnquiryExportHead(enquiryExportHeadVO);
        // 导出单据数据表
        List<EnquiryExportItemVO> enquiryExportItemVOList = enquirySubMapper.selectExportList(enquirySubSearchDTO);
        enquiryExportDataVO.setEnquiryExportList(enquiryExportItemVOList);
        return enquiryExportDataVO;
    }
}
