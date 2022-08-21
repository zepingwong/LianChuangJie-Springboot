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
import com.lianchuangjie.lianchuangjie.mapper.BomQueryMapper;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleRegionMapper;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.BomQueryService;
import com.lianchuangjie.lianchuangjie.service.EnquiryMainService;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BomQueryServiceImpl implements BomQueryService {
    @Resource
    BomQueryMapper bomQueryMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    EnquiryMainService enquiryMainService;
    @Resource
    EnquiryMainMapper enquiryMainMapper;
    @Resource
    EnquirySubService enquirySubService;
    @Resource
    ClienteleRegionMapper clienteleRegionMapper;

    @Override
    public BomQueryResVO query(Long docEntry) {
        BomQueryResVO bomQueryRes = new BomQueryResVO();
        Long userSign = SessionUtil.getUserSign();
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("UserSign", userSign);
        UserEntity user = userMapper.getOne(queryWrapper);
        List<BomQueryItemVO> list = bomQueryMapper.selectList(docEntry, user.getDftDept(), userSign);
        long itemId = Long.parseLong("1");
        long lineNum = Long.parseLong("1");
        for (BomQueryItemVO item : list) {
            item.setLineNum(lineNum); // 行号
            // 序号，关联型号序号相同
            if (Objects.equals(item.getMatch(), "关联型号")) {
                item.setItemId(itemId - 1); // 关联型号Id 与上一行相同
            } else {
                item.setItemId(itemId);
                itemId += 1;
            }
            lineNum += 1;
        }
        bomQueryRes.setBomQueryItemList(list);
        bomQueryRes.setTotalSize(list.size());
        return bomQueryRes;
    }

    @Override
    public Boolean save(BomQuerySaveDTO bomQuerySaveData, UserEntity user) {
        BomQueryMainDTO bomQueryConsInfo = bomQuerySaveData.getBomQueryMain();
        ClienteleRegionEntity clienteleRegion = clienteleRegionMapper.selectById(bomQueryConsInfo.getRegionCode());
        EnquiryMainEntity enquiryMainEntity = new EnquiryMainEntity();
        BeanUtils.copyProperties(bomQueryConsInfo, enquiryMainEntity);
        // 客户简称代码 T_ICIN.U_ShortCode
        enquiryMainEntity.setUShortCode(clienteleRegion.getShortName() + " " + bomQueryConsInfo.getUDomainName() + " " + bomQueryConsInfo.getUCusGroup() + "-" + bomQueryConsInfo.getCardCode().replace("C", ""));
        enquiryMainEntity.setOwnerCode(user.getUserSign()); // 销售员代码
        enquiryMainEntity.setUserSign(user.getUserSign()); // 销售员代码
        enquiryMainEntity.setUUserName(user.getUserName()); // 销售员名称
        enquiryMainEntity.setDeptCode(user.getDftDept()); // 销售部门代码
        enquiryMainEntity.setUDeptName(user.getDftDeptName()); // 销售部门名称
        // 判断是否为老客户
        Boolean oldCus = enquiryMainMapper.existByCardName(enquiryMainEntity.getCardName());
        if (oldCus) {
            // T_ICIN.U_CardStatus = 'Y' 表示该客户第一次询价
            enquiryMainEntity.setUCardStatus("N");
        }
        // 询价单编号
        Long docEntry = enquiryMainMapper.selectMaxDocEntry() + 1;
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
                // 如果是老客户
                if (oldCus) {
                    enquirySubEntity.setKeyPoint("Y");
                    enquirySubEntity.setKeyRemark("以前下过单！");
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
