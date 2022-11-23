package com.lianchuangjie.lianchuangjie.mapper.StockList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface StockListMapper {
    /**
     * @param modle modle
     * @return List
     * @description 获取采购成本价格走势
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/13/2022
     */
    List<BigDecimal> selectPurchasePrice(@Param("modle") String modle);
}
