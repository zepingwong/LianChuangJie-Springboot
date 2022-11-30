package com.lianchuangjie.lianchuangjie.mapper.Company;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.CompanyDepartmentEntity;
import com.lianchuangjie.lianchuangjie.vo.CompanyDepartmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyDepartmentMapper extends BaseMapper<CompanyDepartmentEntity> {
    /**
     * @param queryWrapper queryWrapper
     * @return List
     * @description 查询公司部门
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/30/2022
     */
    List<CompanyDepartmentVO> selectList(@Param("ew") QueryWrapper<CompanyDepartmentVO> queryWrapper);
}
