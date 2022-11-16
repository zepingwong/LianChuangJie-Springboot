package com.lianchuangjie.lianchuangjie.service.User;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.User.LoginLogSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.User.LoginLogEntity;
import com.lianchuangjie.lianchuangjie.vo.User.LoginLogVO;

public interface LoginLogService extends IService<LoginLogEntity> {
    Page<LoginLogVO> list(LoginLogSearchDTO loginLogSearchDTO);
}
