package com.lianchuangjie.lianchuangjie.mapper.Enquiry;

import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMatchItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnquiryBomMatchMapper {
    List<EnquiryMatchItemVO> query(
            @Param("DocEntry") Long docEntry, // 上传 BOM 单编号
            @Param("DeptCode") String deptCode, // 销售部门代码
            @Param("UserSign") Long userSign // 销售编号
    );
}
