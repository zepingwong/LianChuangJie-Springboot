package com.lianchuangjie.lianchuangjie.controller.System;

import com.lianchuangjie.lianchuangjie.dto.System.MenuAddDTO;
import com.lianchuangjie.lianchuangjie.dto.User.EmployeeLoginDTO;
import com.lianchuangjie.lianchuangjie.entity.System.MenuEntity;
import com.lianchuangjie.lianchuangjie.service.System.MenuService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.System.MenuVO;
import com.lianchuangjie.lianchuangjie.vo.User.LoginResVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/system")
@Validated
public class MenuController {
    @Resource
    MenuService menuService;
    @PostMapping("/menu")
    public Result<MenuEntity> addMenuController(@RequestBody @Valid MenuAddDTO menuAddDTO) {
        return Result.success(menuService.add(menuAddDTO), "Success");
    }
    @GetMapping("/menu")
    public Result<List<MenuEntity>> getMenuListController() {
        menuService.list();
    }
}
