package com.lianchuangjie.lianchuangjie.service.Enquiry;

import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryMatchSaveDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySingleQueryDTO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMatchItemVO;

import java.util.List;

/**
 * 询价匹配
 */
public interface EnquiryMatchService {
    /**
     * @param enquirySingleQueryDTO singleQueryDTO
     * @return BomQueryItemVO
     * @description 单个型号匹配
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    List<EnquiryMatchItemVO> querySingle(EnquirySingleQueryDTO enquirySingleQueryDTO);
    /**
     * @param enquirySingleQueryDTOList singleQueryDTO
     * @return BomQueryItemVO
     * @description 多个型号批量匹配
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    List<EnquiryMatchItemVO> queryBatch(List<EnquirySingleQueryDTO> enquirySingleQueryDTOList);
    /**
     * @param docEntry docEntry
     * @return BomQueryResVO
     * @description BOM单匹配解析
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    List<EnquiryMatchItemVO> queryBom(Long docEntry);

    /**
     * @param enquiryMatchSaveDTO enquiryMatchSaveDTO
     * @return Boolean
     * @description 保存匹配结果
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/24/2022
     */
    Boolean save(EnquiryMatchSaveDTO enquiryMatchSaveDTO);
}
