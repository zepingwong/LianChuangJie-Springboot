package com.lianchuangjie.lianchuangjie.service.StockList.impl;


import com.alibaba.excel.EasyExcel;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListMainEntity;
import com.lianchuangjie.lianchuangjie.excel.StockListListener;
import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.StockList.StockListMainMapper;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class StockListUploadServiceImpl implements StockListUploadService {
    @Resource
    StockListMainMapper stockListMainMapper;
    @Override
    public void upload(MultipartFile file, String cardCode) {
        // 文件名
        String fileName = file.getOriginalFilename();
        ResponseEnum.ISNULL.assertNullOrEmpty(fileName, "文件上传错误");
        assert fileName != null;
        ResponseEnum.VALID_ERROR.assertIsFalse((fileName.endsWith(".xls") || fileName.endsWith(".xlsx")), "文件格式错误");
        try {
            StockListListener listener = new StockListListener();
            EasyExcel.read(file.getInputStream(), listener).sheet().doRead();
            // 保存主表信息
            StockListMainEntity stockListMainEntity = new StockListMainEntity();
            stockListMainEntity.setCardCode(cardCode);
            stockListMainEntity.setFileName(fileName);
            stockListMainMapper.insert(stockListMainEntity);
            System.out.println(stockListMainEntity);
        } catch (IOException e) {
            e.printStackTrace();
            throw ResponseEnum.UPLOAD_ERROR.newException("上传错误" + e.getMessage());
        }
    }
}
