package com.lianchuangjie.lianchuangjie.mapper.User;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.User.LoginLogSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.User.LoginLogEntity;
import com.lianchuangjie.lianchuangjie.vo.User.LoginLogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginLogMapper extends BaseMapper<LoginLogEntity> {
    IPage<LoginLogVO> selectList(IPage<LoginLogVO> page, @Param("sc") LoginLogSearchDTO loginLogSearchDTO);
}
