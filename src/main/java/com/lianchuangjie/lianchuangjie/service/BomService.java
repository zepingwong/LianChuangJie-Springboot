package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.dto.BomQuerySaveDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;
import com.lianchuangjie.lianchuangjie.vo.BomUploadResVO;
import org.springframework.web.multipart.MultipartFile;

public interface BomService {
    /**
     * @param docEntry docEntry
     * @return BomQueryResVO
     * @description BOM单匹配解析
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    BomQueryResVO list(Long docEntry);

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
