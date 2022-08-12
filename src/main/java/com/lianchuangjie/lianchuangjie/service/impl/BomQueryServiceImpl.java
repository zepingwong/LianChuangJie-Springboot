package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lianchuangjie.lianchuangjie.entity.UserEntity;
import com.lianchuangjie.lianchuangjie.mapper.BomQueryMapper;
import com.lianchuangjie.lianchuangjie.mapper.UserMapper;
import com.lianchuangjie.lianchuangjie.service.BomQueryService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.BomQueryItemVO;
import com.lianchuangjie.lianchuangjie.vo.BomQueryResVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BomQueryServiceImpl implements BomQueryService {
    @Resource
    BomQueryMapper bomQueryMapper;
    @Resource
    UserMapper userMapper;
    @Override
    public BomQueryResVO queryService(Long docEntry) {
        BomQueryResVO bomQueryRes = new BomQueryResVO();
        Long userSign = SessionUtil.getUserSign();
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("UserSign", userSign);
        UserEntity user = userMapper.getOne(queryWrapper);
        List<BomQueryItemVO> list = bomQueryMapper.selectList(
                docEntry, user.getDftDept(), userSign
        );
        bomQueryRes.setBomQueryItemList(list);
        bomQueryRes.setTotalSize(list.size());
        return bomQueryRes;
    }
}
