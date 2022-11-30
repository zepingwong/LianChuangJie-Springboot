package com.lianchuangjie.lianchuangjie.mapper.CurVat;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.CurVat.ExchangeRateEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExchangeRateMapper extends BaseMapper<ExchangeRateEntity> {
    /**
     * @param currency currency
     * @return ExchangeRateEntity
     * @description 查询某货币最近一次汇率
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 10/30/2022
     */
    ExchangeRateEntity selectOne(@Param("currency") String currency);
}
