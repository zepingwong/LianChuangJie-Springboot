package com.lianchuangjie.lianchuangjie.mapper.Enquiry;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryBomUpdateDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomSubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomExportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BomSubMapper extends BaseMapper<BomSubEntity> {
    Boolean updateOne(@Param("da") EnquiryBomUpdateDTO enquiryBomUpdateDTO);

    List<BomExportVO> selectByDocEntry(@Param("docEntry") Long docEntry);
}
