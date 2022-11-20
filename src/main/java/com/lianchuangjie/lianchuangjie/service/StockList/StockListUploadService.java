package com.lianchuangjie.lianchuangjie.service.StockList;

import org.springframework.web.multipart.MultipartFile;

public interface StockListUploadService {
    void upload(MultipartFile file, String cardCode);
}
