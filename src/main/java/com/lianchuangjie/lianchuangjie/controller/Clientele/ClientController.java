package com.lianchuangjie.lianchuangjie.controller.Clientele;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.Clientele.ClienteleSearchDTO;
import com.lianchuangjie.lianchuangjie.service.Clientele.ClientService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/clientele")
public class ClientController {
    @Resource
    ClientService clientService;
    /**
     * @param cardName cardName
     * @param cardCode cardCode
     * @return Result
     * @description 获取客户列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 08/11/2022
     */
    @GetMapping("/client")
    @Authentication(sale = true)
    public Result<List<ClienteleVO>> getClientListController(
            @RequestParam(defaultValue = "#{null}", value = "CardName") String cardName,
            @RequestParam(defaultValue = "#{null}", value = "CardCode") String cardCode
    ) {
        ClienteleSearchDTO clienteleSearchDTO = new ClienteleSearchDTO();
        clienteleSearchDTO.setCardName(cardName);
        clienteleSearchDTO.setCardCode(cardCode);
        clienteleSearchDTO.setUserSign(SessionUtil.getUser().getUserSign());
        List<ClienteleVO> list = clientService.list(clienteleSearchDTO);
        return Result.success(list, "success");
    }

    /**
     * @param CardCode CardCode
     * @return Result
     * @description 获取单个客户信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 08/11/2022
     */
    @GetMapping("/client/{CardCode}")
    @Authentication(sale = true)
    public Result<ClienteleVO> getClientInfoController(
            @PathVariable String CardCode
    ) {
        ClienteleVO clienteleClientInfoVO = clientService.getOne(CardCode);
        return Result.success(clienteleClientInfoVO, "success");
    }
}
