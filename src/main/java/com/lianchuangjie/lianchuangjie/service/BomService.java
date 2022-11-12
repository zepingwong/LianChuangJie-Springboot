package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.dto.BomQuerySaveDTO;
import com.lianchuangjie.lianchuangjie.entity.User.UserEntity;
import com.lianchuangjie.lianchuangjie.vo.BomUploadResVO;
import org.springframework.web.multipart.MultipartFile;

public interface BomService {
    /**
     * @param file file
     * @return BomUploadResVO
     * @description 上传Bom单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    BomUploadResVO upload(MultipartFile file);

    /**
     * @param bomQuerySaveDTO bomQuerySaveDTO
     * @param user            user
     * @return Boolean
     * @description 保存Bom单解析结果
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    Boolean save(BomQuerySaveDTO bomQuerySaveDTO, UserEntity user);
}
