package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {
    UserEntity getOne(@Param("ew") QueryWrapper<UserEntity> queryWrapper);
    UserInfoVO getInfo(@Param("ew") QueryWrapper<UserInfoVO> queryWrapper);
}
