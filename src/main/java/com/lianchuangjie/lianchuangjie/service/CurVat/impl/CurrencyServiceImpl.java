package com.lianchuangjie.lianchuangjie.service.CurVat.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.CurVat.CurrencyEntity;
import com.lianchuangjie.lianchuangjie.mapper.CurVat.CurrencyMapper;
import com.lianchuangjie.lianchuangjie.service.CurVat.CurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl extends ServiceImpl<CurrencyMapper, CurrencyEntity> implements CurrencyService {
}
