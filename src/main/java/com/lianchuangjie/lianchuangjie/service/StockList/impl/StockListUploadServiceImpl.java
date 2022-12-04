package com.lianchuangjie.lianchuangjie.service.StockList.impl;


import com.alibaba.excel.EasyExcel;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListMainEntity;
import com.lianchuangjie.lianchuangjie.entity.StockList.StockListSubEntity;
import com.lianchuangjie.lianchuangjie.excel.StockListListener;
import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.StockList.StockListSubMapper;
import com.lianchuangjie.lianchuangjie.service.Clientele.SupplierService;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListMainService;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListSubService;
import com.lianchuangjie.lianchuangjie.service.StockList.StockListUploadService;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class StockListUploadServiceImpl implements StockListUploadService {
    @Resource
    StockListMainService stockListMainService;
    @Resource
    StockListSubService stockListSubService;
    @Resource
    StockListSubMapper stockListSubMapper;
    @Resource
    SupplierService supplierService;
    @Override
    public void upload(MultipartFile file, String cardCode) {
        // 文件名
        String fileName = file.getOriginalFilename();
        ResponseEnum.ISNULL.assertNullOrEmpty(fileName, "文件上传错误");
        assert fileName != null;
        ResponseEnum.VALID_ERROR.assertIsFalse((fileName.endsWith(".xls") || fileName.endsWith(".xlsx")), "文件格式错误");
        ClienteleVO supplierInfo = supplierService.getOne(cardCode);
        try {
            StockListListener listener = new StockListListener();
            EasyExcel.read(file.getInputStream(), listener).sheet().doRead();
            // 保存主表信息
            StockListMainEntity stockListMainEntity = new StockListMainEntity();
            stockListMainEntity.setCardCode(cardCode); // 供应商代码
            stockListMainEntity.setCardName(supplierInfo.getCardName()); //供应商名称
            stockListMainEntity.setStatus("N"); // 状态 未处理
            stockListMainEntity.setFileName(fileName); // 文件名
            stockListMainEntity.setLevel(supplierInfo.getUCusLevel()); // 供应商等级
            stockListMainEntity.setGroupName(supplierInfo.getUGroupName()); // 供应商类型
            stockListMainEntity.setCreateDate(new Date()); // 发送时间
            stockListMainService.save(stockListMainEntity);
            log.info("保存库存清单主表成功 {}", stockListMainEntity);
            List<StockListSubEntity> stockListSubEntityList = listener.getStockListSubList();
            stockListSubEntityList.forEach(stockListSubEntity -> stockListSubEntity.setDocEntry(stockListMainEntity.getDocEntry()));
            // 批量保存子表
            stockListSubService.saveBatch(stockListSubEntityList);
            // 匹配型号
            stockListSubMapper.match(stockListMainEntity.getDocEntry());
        } catch (IOException e) {
            e.printStackTrace();
            throw ResponseEnum.UPLOAD_ERROR.newException("上传错误" + e.getMessage());
        }
    }
}
