package com.lianchuangjie.lianchuangjie.mapper.User;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.User.LoginLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginLogMapper extends BaseMapper<LoginLogEntity> {

}
