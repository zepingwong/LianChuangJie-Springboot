package com.lianchuangjie.lianchuangjie.controller.Clientele;

import com.lianchuangjie.lianchuangjie.config.Authentication;
import com.lianchuangjie.lianchuangjie.dto.Clientele.ClienteleSearchDTO;
import com.lianchuangjie.lianchuangjie.service.Clientele.SupplierService;
import com.lianchuangjie.lianchuangjie.utils.Result;
import com.lianchuangjie.lianchuangjie.utils.ContextUtil;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/clientele")
public class SupplierController {
    @Resource
    SupplierService supplierService;
    /**
     * @param cardName cardName
     * @param cardCode cardCode
     * @return Result
     * @description 获取供应商列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 08/11/2022
     */
    @GetMapping("/supplier")
    @Authentication(buyer = true)
    public Result<List<ClienteleVO>> getSupplierListController(
            @RequestParam(defaultValue = "#{null}", value = "CardName") String cardName,
            @RequestParam(defaultValue = "#{null}", value = "CardCode") String cardCode
    ) {
        ClienteleSearchDTO clienteleSearchDTO = new ClienteleSearchDTO();
        clienteleSearchDTO.setCardName(cardName);
        clienteleSearchDTO.setCardCode(cardCode);
        clienteleSearchDTO.setUserSign(ContextUtil.getUser().getUserSign());
        List<ClienteleVO> list = supplierService.list(clienteleSearchDTO);
        return Result.success(list, "success");
    }

    /**
     * @param CardCode CardCode
     * @return Result
     * @description 获取单个供应商信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 08/11/2022
     */
    @GetMapping("/supplier/{CardCode}")
    @Authentication(buyer = true)
    public Result<ClienteleVO> getSupplierInfoController(
            @PathVariable String CardCode
    ) {
        ClienteleVO clienteleClientInfo = supplierService.getOne(CardCode);
        return Result.success(clienteleClientInfo, "success");
    }
}
