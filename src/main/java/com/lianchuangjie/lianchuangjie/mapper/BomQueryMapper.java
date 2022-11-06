package com.lianchuangjie.lianchuangjie.mapper;

import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySingleQueryDTO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BomQueryMapper {
    List<BomQueryItemVO> queryRelated(@Param("sc") EnquirySingleQueryDTO enquirySingleQueryDTO);
}
