package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.CompanyDepartmentEntity;
import com.lianchuangjie.lianchuangjie.vo.CompanyDepartmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyDepartmentMapper extends BaseMapper<CompanyDepartmentEntity> {
    List<CompanyDepartmentVO> selectList(@Param("ew") QueryWrapper<CompanyDepartmentVO> queryWrapper);
}
