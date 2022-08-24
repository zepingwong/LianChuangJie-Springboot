package com.lianchuangjie.lianchuangjie.service.impl;

import com.alibaba.excel.EasyExcel;
import com.lianchuangjie.lianchuangjie.dto.BomQueryMainDTO;
import com.lianchuangjie.lianchuangjie.dto.BomQuerySaveDTO;
import com.lianchuangjie.lianchuangjie.dto.BomQuerySubDTO;
import com.lianchuangjie.lianchuangjie.entity.*;
import com.lianchuangjie.lianchuangjie.excel.BomListener;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.BomHeadDicMapper;
import com.lianchuangjie.lianchuangjie.mapper.ClienteleRegionMapper;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.service.*;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.BomUploadResVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class BomUploadServiceImpl implements BomUploadService {
    @Resource
    BomHeadDicMapper bomHeadDicMapper;
    @Resource
    BomMainService bomMainService;
    @Resource
    BomSubService bomSubService;
    @Resource
    EnquiryMainService enquiryMainService;
    @Resource
    EnquiryMainMapper enquiryMainMapper;
    @Resource
    EnquirySubService enquirySubService;
    @Resource
    ClienteleRegionMapper clienteleRegionMapper;

    @Override
    public BomUploadResVO uploadService(MultipartFile file) {
        // 返回数据类型
        BomUploadResVO bomUploadResVO = new BomUploadResVO();
        // 上传BOM单文件名
        String fileName = file.getOriginalFilename();
        ResponseEnum.ISNULL.assertNullOrEmpty(fileName, "文件上传错误");
        assert fileName != null;
        ResponseEnum.VALID_ERROR.assertIsFalse((fileName.endsWith(".xls") || fileName.endsWith(".xlsx")), "文件格式错误");
        List<Map<String, String>> bomList;
        try {
            BomListener listener = new BomListener(bomHeadDicMapper.selectById(1));
            EasyExcel.read(file.getInputStream(), listener).sheet().doRead();
            bomList = listener.getDataList();
            List<String> titleList = listener.getTitleList();
            List<BomSubEntity> bomSubList = listener.getBomSubList();
            bomUploadResVO.setBomItemList(bomList);
            bomUploadResVO.setTitleList(titleList);
            // 保存Bom单主表信息
            BomMainEntity bomMainEntity = new BomMainEntity();
            bomMainEntity.setFileName(fileName);
            bomMainEntity.setOwnerCode(SessionUtil.getUserSign());
            bomMainService.save(bomMainEntity);
            // 主表信息保存后，BomMainEntity产生DocEntry
            Long docEntry = bomMainEntity.getDocEntry();
            bomUploadResVO.setDocEntry(docEntry);
            // 保存Bom单子表信息
            bomSubList.forEach(bomSubEntity -> bomSubEntity.setDocEntry(docEntry));
            bomSubService.saveBatch(bomSubList);
        } catch (IOException e) {
            e.printStackTrace();
            throw ResponseEnum.UPLOAD_ERROR.newException("上传错误" + e.getMessage());
        }
        return bomUploadResVO;
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
