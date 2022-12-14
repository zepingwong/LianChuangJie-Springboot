package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomUploadResVO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomExportVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
     * @param docEntry docEntry
     * @return List
     * @description 导出Bom单标准化结果
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/20/2022
     */
    List<BomExportVO> export(Long docEntry);
}
