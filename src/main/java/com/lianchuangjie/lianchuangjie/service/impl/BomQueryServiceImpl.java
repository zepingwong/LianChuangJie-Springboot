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
import java.util.Objects;

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
        long itemId = Long.parseLong("1");
        long lineNum = Long.parseLong("1");
        for (BomQueryItemVO item: list) {
            item.setLineNum(lineNum); // 行号
            // 序号，关联型号序号相同
            if (Objects.equals(item.getMatch(), "关联型号")) {
                item.setItemId(itemId-1); // 关联型号Id 与上一行相同
            } else {
                item.setItemId(itemId);
                itemId += 1;
            }
            lineNum += 1;
        }
        bomQueryRes.setBomQueryItemList(list);
        bomQueryRes.setTotalSize(list.size());
        return bomQueryRes;
    }
}
