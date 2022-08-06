package com.lianchuangjie.lianchuangjie.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    UserEntity selectByUserCode(@Param("UserCode") String userCode);
}
