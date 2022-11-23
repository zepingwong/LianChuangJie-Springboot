package com.lianchuangjie.lianchuangjie.mapper.StockRank;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.StockRank.StockRankSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.StockRank.StockRankEntity;
import com.lianchuangjie.lianchuangjie.vo.StockRank.PurchaseOrderVO;
import com.lianchuangjie.lianchuangjie.vo.StockRank.StockRankVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface StockRankMapper extends BaseMapper<StockRankEntity> {
    /**
     * @param page               page
     * @param stockRankSearchDTO stockRankSearchDTO
     * @return IPage
     * @description 获取库存定价列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    IPage<StockRankVO> selectList(IPage<StockRankVO> page, @Param("sc") StockRankSearchDTO stockRankSearchDTO);

    /**
     * @param modle modle
     * @return List
     * @description 获取采购成本价格走势
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    List<BigDecimal> selectPurchasePrice(@Param("modle") String modle);

    /**
     * @param stockRankSearchDTO stockRankSearchDTO
     * @return List
     * @description 在途库存获取采购订单
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/23/2022
     */
    List<PurchaseOrderVO> selectPurchaseOrder(@Param("sc") StockRankSearchDTO stockRankSearchDTO);

    /**
     * @param stockRankSearchDTO stockRankSearchDTO
     * @return StockRankVO
     * @description 库存排名详情
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/24/2022
     */
    StockRankVO selectOne(@Param("sc") StockRankSearchDTO stockRankSearchDTO);
}
