package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.dto.BomQuerySaveDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.vo.BomUploadResVO;
import org.springframework.web.multipart.MultipartFile;

public interface BomUploadService {
    BomUploadResVO uploadService(MultipartFile file);
    Boolean save(BomQuerySaveDTO bomQuerySaveDTO, UserEntity user);
}
