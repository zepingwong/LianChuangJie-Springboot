package com.lianchuangjie.lianchuangjie.service.System;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.System.MenuAddDTO;
import com.lianchuangjie.lianchuangjie.entity.System.MenuEntity;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.System.MenuVO;

public interface MenuService extends IService<MenuEntity> {
    MenuEntity add(MenuAddDTO menuAddDTO);
}
