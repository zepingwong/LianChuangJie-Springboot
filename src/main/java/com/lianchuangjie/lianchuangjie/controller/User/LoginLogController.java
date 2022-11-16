package com.lianchuangjie.lianchuangjie.controller.User;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.User.LoginLogSearchDTO;
import com.lianchuangjie.lianchuangjie.service.User.LoginLogService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.User.LoginLogVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/login")
@Validated
public class LoginLogController {
    @Resource
    LoginLogService loginLogService;
    @GetMapping("log")
    @Authentication()
    public Result<Page<LoginLogVO>> getLoginLogController(
            @RequestParam(defaultValue = "#{null}", value = "page") Integer page,
            @RequestParam(defaultValue = "#{null}", value = "size") Integer size
    ) {
        LoginLogSearchDTO loginLogSearchDTO = new LoginLogSearchDTO(page, size);
        Page<LoginLogVO> pages = loginLogService.list(loginLogSearchDTO);
        return Result.success(pages, "Success");
    }
}
