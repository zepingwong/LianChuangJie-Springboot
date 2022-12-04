package com.lianchuangjie.lianchuangjie.service.StockList;

import com.lianchuangjie.lianchuangjie.dto.StockList.SupplierInfoDTO;
import org.springframework.web.multipart.MultipartFile;

public interface StockListUploadService {
    void upload(MultipartFile file, SupplierInfoDTO supplierInfoDTO);
}
