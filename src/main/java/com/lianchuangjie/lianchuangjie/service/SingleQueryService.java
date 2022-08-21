package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.dto.SingleQueryDTO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;

public interface SingleQueryService {
    BomQueryItemVO query(SingleQueryDTO singleQueryDTO);
}
