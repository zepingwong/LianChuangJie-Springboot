package com.lianchuangjie.lianchuangjie.service.impl;

import com.lianchuangjie.lianchuangjie.dto.search.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.mapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.EnquiryExportService;
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
    public EnquiryExportDataVO export(Long docEntry) {
        EnquiryMainEntity enquiryMainEntity = enquiryMainMapper.selectByDocEntry(docEntry, SessionUtil.getUserSign());
        Integer state = enquiryMainEntity.getState();
        enquiryMainEntity.setState(state + 1);
        EnquiryExportDataVO enquiryExportDataVO = new EnquiryExportDataVO();
        EnquiryExportHeadVO enquiryExportHeadVO = new EnquiryExportHeadVO();
        enquiryExportHeadVO.setSubject("报价");
        enquiryExportDataVO.setEnquiryExportHead(enquiryExportHeadVO);
        // 导出单据
        EnquirySubSearchDTO enquirySubSearchDTO = new EnquirySubSearchDTO();
        enquirySubSearchDTO.setDocEntry(docEntry);
        enquirySubSearchDTO.setOwnerCode(SessionUtil.getUserSign());
        List<EnquiryExportItemVO> enquiryExportItemVOList = enquirySubMapper.export(enquirySubSearchDTO);
        enquiryExportDataVO.setEnquiryExportList(enquiryExportItemVOList);
        return enquiryExportDataVO;
    }
}
