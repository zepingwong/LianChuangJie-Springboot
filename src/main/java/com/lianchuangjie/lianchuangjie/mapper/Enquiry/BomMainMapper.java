package com.lianchuangjie.lianchuangjie.mapper.Enquiry;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.BomMainSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.BomMainEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.BomMainVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BomMainMapper extends BaseMapper<BomMainEntity> {
    IPage<BomMainVO> selectList(Page<BomMainVO> page, @Param("sc") BomMainSearchDTO bomMainSearchDTO);
}
