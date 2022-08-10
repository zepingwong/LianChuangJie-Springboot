package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.BomMainEntity;
import com.lianchuangjie.lianchuangjie.service.BomMainService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
@Service
public class BomMainServiceImpl implements BomMainService {
    @Override
    public boolean saveBatch(Collection<BomMainEntity> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<BomMainEntity> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<BomMainEntity> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(BomMainEntity entity) {
        return false;
    }

    @Override
    public BomMainEntity getOne(Wrapper<BomMainEntity> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<BomMainEntity> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<BomMainEntity> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<BomMainEntity> getBaseMapper() {
        return null;
    }

    @Override
    public Class<BomMainEntity> getEntityClass() {
        return null;
    }
}
