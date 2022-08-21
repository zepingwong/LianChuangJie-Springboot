package com.lianchuangjie.lianchuangjie.mapper;

import com.lianchuangjie.lianchuangjie.dto.SingleQueryDTO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SingleQueryMapper {
    BomQueryItemVO selectOne(@Param("sc") SingleQueryDTO singleQueryDTO);
}
