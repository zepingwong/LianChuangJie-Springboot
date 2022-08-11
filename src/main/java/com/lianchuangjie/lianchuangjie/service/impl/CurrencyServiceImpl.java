package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.CurrencyEntity;
import com.lianchuangjie.lianchuangjie.mapper.CurrencyMapper;
import com.lianchuangjie.lianchuangjie.service.CurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl extends ServiceImpl<CurrencyMapper, CurrencyEntity> implements CurrencyService {
}
