package com.lianchuangjie.lianchuangjie.controller;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.service.ClientService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.vo.ClientInfoVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleItemVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/clientele")
public class ClientController {
    @Resource
    ClientService clientService;

    @GetMapping("/client")
    @Authentication(sale = true)
    public Result<List<ClienteleItemVO>> getClientListController(
            @RequestParam(defaultValue = "#{null}", value = "CardName") String CardName
    ) {
        List<ClienteleItemVO> list = clientService.queryListService(CardName);
        return Result.success(list);
    }

    @GetMapping("/client/{CardCode}")
    public Result<ClientInfoVO> getClientInfoController(
            @PathVariable String CardCode
    ) {
        ClientInfoVO clientInfoVO = clientService.queryInfoService(CardCode);
        return Result.success(clientInfoVO);
    }
}
