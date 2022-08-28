package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.dto.SingleQueryDTO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;

import java.util.List;

public interface QueryService {
    /**
     * @param docEntry docEntry
     * @return BomQueryResVO
     * @description BOM单匹配匹配
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    BomQueryResVO queryBom(Long docEntry);

    /**
     * @param singleQueryDTO singleQueryDTO
     * @return BomQueryItemVO
     * @description 单个型号匹配
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    BomQueryItemVO querySingle(SingleQueryDTO singleQueryDTO);

    /**
     * @param singleQueryDTO singleQueryDTO
     * @return List
     * @description 关联型号匹配
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    List<BomQueryItemVO> queryRelated(SingleQueryDTO singleQueryDTO);
}
