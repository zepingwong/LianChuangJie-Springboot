package com.lianchuangjie.lianchuangjie.mapper.CurVat;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.CurVat.CurrencyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CurrencyMapper extends BaseMapper<CurrencyEntity> {
}
