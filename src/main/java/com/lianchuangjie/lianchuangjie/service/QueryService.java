package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.dto.SingleQueryDTO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;

import java.util.List;

public interface QueryService {
    BomQueryResVO queryBom(Long docEntry);
    BomQueryItemVO querySingle(SingleQueryDTO singleQueryDTO);
    List<BomQueryItemVO> queryRelated(SingleQueryDTO singleQueryDTO);
}
