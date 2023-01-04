package com.lianchuangjie.lianchuangjie.mapper.Enquiry;

import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySingleQueryDTO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMatchItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnquiryBatchMatchMapper {
    List<EnquiryMatchItemVO> query(
            @Param("modleList") List<String> enquirySingleQueryDTOList,
            @Param("DeptCode") String DeptCode,
            @Param("UserSign") Long UserSign
    );
}
