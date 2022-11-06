package com.lianchuangjie.lianchuangjie.mapper.Enquiry;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryBomUpdateDTO;
import com.lianchuangjie.lianchuangjie.entity.BomSubEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BomSubMapper extends BaseMapper<BomSubEntity> {
    Boolean updateOne(@Param("da") EnquiryBomUpdateDTO enquiryBomUpdateDTO);
}
