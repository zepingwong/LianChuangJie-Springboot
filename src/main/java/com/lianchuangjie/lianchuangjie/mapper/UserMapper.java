package com.lianchuangjie.lianchuangjie.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByUserCode(@Param("UserCode") String userCode);
}
