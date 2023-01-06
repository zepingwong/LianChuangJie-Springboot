package com.lianchuangjie.lianchuangjie.mapper.System;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.System.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MenuMapper extends BaseMapper<MenuEntity> {
}
