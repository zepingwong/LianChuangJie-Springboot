package com.lianchuangjie.lianchuangjie.service.impl;

import com.alibaba.excel.EasyExcel;
import com.lianchuangjie.lianchuangjie.entity.BomMainEntity;
import com.lianchuangjie.lianchuangjie.entity.BomSubEntity;
import com.lianchuangjie.lianchuangjie.excel.BomListener;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.BomHeadDicMapper;
import com.lianchuangjie.lianchuangjie.service.BomMainService;
import com.lianchuangjie.lianchuangjie.service.BomSubService;
import com.lianchuangjie.lianchuangjie.service.BomUploadService;
import com.lianchuangjie.lianchuangjie.vo.BomUploadResVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class BomUploadServiceImpl implements BomUploadService {
    @Resource
    BomHeadDicMapper bomHeadDicMapper;
    @Resource
    BomMainService bomMainService;
    @Resource
    BomSubService bomSubService;

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
}
