package com.lianchuangjie.lianchuangjie.service;

import com.lianchuangjie.lianchuangjie.dto.BomQuerySaveDTO;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;

public interface BomQueryService {
    BomQueryResVO query(Long docEntry);
    Boolean save(BomQuerySaveDTO bomQuerySaveDTO, UserEntity user);
}
