package com.lianchuangjie.lianchuangjie.service.StockRank;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.StockRank.StockRankSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockRank.StockRankEntity;
import com.lianchuangjie.lianchuangjie.vo.StockRank.PurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankVO;

import java.math.BigDecimal;
import java.util.List;

public interface StockRankService extends IService<StockRankEntity> {
    /**
     * @param stockRankSearchDTO stockRankSearchDTO
     * @return Page
     * @description 获取库存排名列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    Page<StockRankVO> list(StockRankSearchDTO stockRankSearchDTO);

    /**
     * @param modle modle
     * @return List
     * @description 获取某型号采购成本价格走势
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    List<BigDecimal> purchasePriceList(String modle);

    /**
     * @param stockRankSearchDTO stockRankSearchDTO
     * @return List
     * @description 在途库存获取采购订单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/23/2022
     */
    List<PurchaseOrderVO> purchaseOrderList(StockRankSearchDTO stockRankSearchDTO);

    /**
     * @param stockRankSearchDTO stockRankSearchDTO
     * @return StockRankVO
     * @description 库存排名详情
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/24/2022
     */
    StockRankVO getOne(StockRankSearchDTO stockRankSearchDTO);
}
