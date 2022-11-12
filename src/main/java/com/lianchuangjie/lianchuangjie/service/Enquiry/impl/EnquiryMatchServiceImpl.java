package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryMatchHeadDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryMatchItemDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryMatchSaveDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySingleQueryDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.Enquiry.EnquiryError;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquiryBatchMatchMapper;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquiryBomMatchMapper;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquirySingleMatchMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryMainService;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryMatchService;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMatchItemVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EnquiryMatchServiceImpl implements EnquiryMatchService {
    @Resource
    EnquirySingleMatchMapper enquirySingleMatchMapper;
    @Resource
    EnquiryBatchMatchMapper enquiryBatchMatchMapper;
    @Resource
    EnquiryBomMatchMapper enquiryBomMatchMapper;
    @Resource
    EnquiryMainMapper enquiryMainMapper;
    @Resource
    EnquiryMainService enquiryMainService;

    @Resource
    EnquirySubService enquirySubService;

    private void setUserInfo(EnquirySingleQueryDTO enquirySingleQueryDTO) {
        UserEntity user = SessionUtil.getUser();
        enquirySingleQueryDTO.setSlpCode(user.getUserSign());
        enquirySingleQueryDTO.setDeptCode(user.getDftDept());
    }

    @Override
    public List<EnquiryMatchItemVO> querySingle(EnquirySingleQueryDTO enquirySingleQueryDTO) {
        // 当前登录用户
        setUserInfo(enquirySingleQueryDTO);
        System.out.println(enquirySingleQueryDTO);
        return enquirySingleMatchMapper.query(enquirySingleQueryDTO);
    }

    @Override
    public List<EnquiryMatchItemVO> queryBatch(List<EnquirySingleQueryDTO> enquirySingleQueryDTOList) {
        UserEntity user = SessionUtil.getUser();
        return enquiryBatchMatchMapper.query(enquirySingleQueryDTOList, user.getDftDept(), user.getUserSign());
    }

    @Override
    public List<EnquiryMatchItemVO> queryBom(Long docEntry) {
        UserEntity user = SessionUtil.getUser();
        return enquiryBomMatchMapper.query(docEntry, user.getDftDept(), user.getUserSign());
    }

    @Override
    public Boolean save(EnquiryMatchSaveDTO enquiryMatchSaveDTO) {
        // 销售员
        UserEntity user = SessionUtil.getUser();
        EnquiryMatchHeadDTO enquiryMatchHead = enquiryMatchSaveDTO.getEnquiryMatchHead();
        EnquiryMainEntity enquiryMainEntity = new EnquiryMainEntity();
        BeanUtils.copyProperties(enquiryMatchHead, enquiryMainEntity);
        // 询价单编号
        Long docEntry = enquiryMainMapper.selectMaxDocEntry() + 1;
        enquiryMainEntity.setDocEntry(docEntry);
        // 保存询价单主表信息
        boolean res = enquiryMainService.save(enquiryMainEntity);
        // 断言判断是否保存成功
        EnquiryError.SAVE_ERROR.assertIsFalse(res);
        List<EnquiryMatchItemDTO> list = enquiryMatchSaveDTO.getEnquiryMatchItemList();
        List<EnquirySubEntity> saveList = new ArrayList<>();
        long lineNum = 1;
        for (EnquiryMatchItemDTO item : list) {
            EnquirySubEntity enquirySubEntity = new EnquirySubEntity();
            BeanUtils.copyProperties(item, enquirySubEntity);
            if (!Objects.equals(item.getMatch(), "未匹配到")) {
                // 设置询价单编号与主表相同
                enquirySubEntity.setDocEntry(docEntry);
                // LineNum 连续编号
                enquirySubEntity.setLineNum(lineNum);
                if (Objects.equals(item.getMatch(), "关联型号")) {
                    // 关联型号 ItemId 相同, 等于该组的第一个LineNum（ItemId 不等于 LineNum）
                    enquirySubEntity.setItemId(lineNum - 1);
                } else {
                    // 非关联型号 ItemId 与 LineNum 相同
                    enquirySubEntity.setItemId(lineNum);
                }
                // 如果是老客户,自动标记为重点询价,重点询价说明为 “以前下过单！”,标记重点询价用户为当前销售员
                if (enquiryMatchHead.getOldCustomer().equals("Y")) {
                    enquirySubEntity.setKeyUser(user.getUserSign());
                }
                saveList.add(enquirySubEntity);
                lineNum++;
            }
        }
        enquirySubService.saveBatch(saveList);
        return true;
    }
}

