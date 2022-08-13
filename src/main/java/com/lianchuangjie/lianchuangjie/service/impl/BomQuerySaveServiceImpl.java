package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.dto.BomQueryMainDTO;
import com.lianchuangjie.lianchuangjie.dto.BomQuerySaveDTO;
import com.lianchuangjie.lianchuangjie.dto.BomQuerySubDTO;
import com.lianchuangjie.lianchuangjie.entity.ClienteleRegionEntity;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleRegionMapper;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.BomQuerySaveService;
import com.lianchuangjie.lianchuangjie.service.EnquiryMainService;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import org.apache.poi.ss.formula.functions.WeekNum;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BomQuerySaveServiceImpl implements BomQuerySaveService {
    @Resource
    EnquiryMainService enquiryMainService;
    @Resource
    EnquiryMainMapper enquiryMainMapper;
    @Resource
    EnquirySubService enquirySubService;
    @Resource
    UserMapper userMapper;
    @Resource
    ClienteleRegionMapper clienteleRegionMapper;

    @Override
    public Boolean save(BomQuerySaveDTO bomQuerySaveData) {
        BomQueryMainDTO bomQueryConsInfo = bomQuerySaveData.getBomQueryMain();
        ClienteleRegionEntity clienteleRegion = clienteleRegionMapper.selectById(bomQueryConsInfo.getRegionCode());
        EnquiryMainEntity enquiryMainEntity = new EnquiryMainEntity();
        BeanUtils.copyProperties(bomQueryConsInfo, enquiryMainEntity);
        enquiryMainEntity.setUShortCode(clienteleRegion.getShortName() +
                " " +
                bomQueryConsInfo.getUDomainName() +
                " " +
                bomQueryConsInfo.getUCusGroup() +
                "-"
        );

        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("UserSign", SessionUtil.getUserSign());
        UserEntity user = userMapper.getOne(queryWrapper);
        enquiryMainEntity.setOwnerCode(user.getUserSign()); // 销售员代码
        enquiryMainEntity.setUserSign(user.getUserSign()); // 销售员代码
        enquiryMainEntity.setUUserName(user.getUserName()); // 销售员名称
        enquiryMainEntity.setDeptCode(user.getDftDept()); // 销售部门代码
        enquiryMainEntity.setUDeptName(user.getDftDeptName()); // 销售部门名称
        // 询价单编号
        Long docEntry = enquiryMainMapper.selectMaxDocEntry()+1;
        enquiryMainEntity.setDocEntry(docEntry);
        // 保存询价单主表信息
        boolean res = enquiryMainService.save(enquiryMainEntity);
        if (!res) ResponseEnum.FAILURE.assertIsFalse(false);

        List<BomQuerySubDTO> list = bomQuerySaveData.getBomQuerySubList();
        List<EnquirySubEntity> saveList = new ArrayList<>();
        long lineNum = 1;
        for (BomQuerySubDTO item : list) {
            if (!Objects.equals(item.getMatch(), "未匹配到")) {
                EnquirySubEntity enquirySubEntity = new EnquirySubEntity();
                BeanUtils.copyProperties(item, enquirySubEntity);
                enquirySubEntity.setDocEntry(docEntry);
                enquirySubEntity.setLineNum(lineNum);
                saveList.add(enquirySubEntity);
                lineNum ++;
            }
        }
        enquirySubService.saveBatch(saveList);
        System.out.println(enquiryMainEntity);
        return true;
    }
}
