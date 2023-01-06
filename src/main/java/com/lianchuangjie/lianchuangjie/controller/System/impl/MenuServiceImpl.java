package com.lianchuangjie.lianchuangjie.controller.System.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.System.MenuAddDTO;
import com.lianchuangjie.lianchuangjie.entity.System.MenuEntity;
import com.lianchuangjie.lianchuangjie.mapper.System.MenuMapper;
import com.lianchuangjie.lianchuangjie.service.System.MenuService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.System.MenuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service

public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {
    @Resource
    MenuMapper menuMapper;
    @Override
    public MenuEntity add(MenuAddDTO menuAddDTO) {
        MenuEntity menuEntity = new MenuEntity();
        BeanUtils.copyProperties(menuAddDTO, menuEntity);
        menuMapper.insert(menuEntity);
        return menuEntity;
    }
}
