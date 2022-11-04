package com.lianchuangjie.lianchuangjie.service.Clientele;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.Clientele.ClienteleSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleVO;

import java.util.List;

public interface SupplierService extends IService<ClienteleEntity> {
    List<ClienteleVO> list(ClienteleSearchDTO clienteleSearchDTO);
    ClienteleVO getOne(String CardCode);
}
