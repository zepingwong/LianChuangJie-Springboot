package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryExportSaveDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryQuoteService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportDataVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportHeadVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportItemVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnquiryQuoteServiceImpl implements EnquiryQuoteService {
    @Resource
    EnquiryMainMapper enquiryMainMapper;
    @Resource
    EnquirySubMapper enquirySubMapper;

    @Override
    public EnquiryExportDataVO list(Long docEntry) {
        // 查询数据：表头+数据表
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
        List<EnquiryExportItemVO> enquiryExportItemVOList = enquirySubMapper.selectQuoteList(enquirySubSearchDTO);
        enquiryExportDataVO.setEnquiryExportList(enquiryExportItemVOList);
        return enquiryExportDataVO;
    }

    @Override
    public Boolean save(EnquiryExportSaveDTO enquiryExportSaveDTO) {
        QueryWrapper<EnquiryMainEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("T_ICIN.DocEntry", enquiryExportSaveDTO.getDocEntry());
        EnquiryMainEntity enquiryMainEntity = enquiryMainMapper.selectByDocEntry(enquiryExportSaveDTO.getDocEntry(), SessionUtil.getUser().getUserSign());
        // 更新表头信息
        enquiryMainEntity.setUFromCompany(enquiryExportSaveDTO.getUFromCompany()); // 报价公司抬头
        enquiryMainEntity.setUSenderName(enquiryExportSaveDTO.getUSenderName()); // 发件人姓名
        enquiryMainEntity.setUSenderTel(enquiryExportSaveDTO.getUSenderTel()); // 发件人电话
        enquiryMainEntity.setURecipientName(enquiryExportSaveDTO.getURecipientName()); // 收件人姓名
        enquiryMainEntity.setURecipientTel(enquiryExportSaveDTO.getURecipientTel()); // 收件人电话
        enquiryMainEntity.setUFreightPayment(enquiryExportSaveDTO.getUFreightPayment()); // 运费
        enquiryMainEntity.setUPaymentMethod(enquiryExportSaveDTO.getUPaymentMethod()); // 支付方式
        return enquiryMainMapper.update(enquiryMainEntity, queryWrapper) == 1;
    }
}
