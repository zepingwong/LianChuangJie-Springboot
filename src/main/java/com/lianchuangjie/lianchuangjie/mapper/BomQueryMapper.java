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
    List<BomQueryItemVO> queryBom(
            @Param("DocEntry") Long docEntry, // 上传 BOM 单编号
            @Param("DeptCode") String deptCode, // 销售部门代码
            @Param("UserSign") Long userSign // 销售编号
    );
    List<BomQueryItemVO> queryRelated(@Param("sc") EnquirySingleQueryDTO enquirySingleQueryDTO);
}
