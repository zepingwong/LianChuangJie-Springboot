package com.lianchuangjie.lianchuangjie.mapper.Enquiry;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.EnquiryBuyerEntity;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryBuyerSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryBuyerItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnquiryBuyerMapper extends BaseMapper<EnquiryBuyerEntity> {
    List<EnquiryBuyerItemVO> selectList(@Param("sc") EnquiryBuyerSearchDTO enquiryBuyerSearchDTO);
}
