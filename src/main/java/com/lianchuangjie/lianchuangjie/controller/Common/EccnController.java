package com.lianchuangjie.lianchuangjie.controller.Common;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.EccnVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EccnController {
    @GetMapping("eccn")
    @Authentication(buyer = true, sale = true)
    public Result<List<EccnVO>> getEccnListController() {
        return Result.success();
    }
}
