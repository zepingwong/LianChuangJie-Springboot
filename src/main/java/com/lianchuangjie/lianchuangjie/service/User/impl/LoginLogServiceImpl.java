package com.lianchuangjie.lianchuangjie.service.User.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.User.LoginLogSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.User.LoginLogEntity;
import com.lianchuangjie.lianchuangjie.mapper.User.LoginLogMapper;
import com.lianchuangjie.lianchuangjie.service.User.LoginLogService;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankVO;
import com.lianchuangjie.lianchuangjie.vo.User.LoginLogVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLogEntity> implements LoginLogService {
    @Resource
    LoginLogMapper loginLogMapper;
    @Override
    public Page<LoginLogVO> list(LoginLogSearchDTO searchCondition) {
        Page<LoginLogVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        loginLogMapper.selectList(page, searchCondition);
        return page;
    }
}
