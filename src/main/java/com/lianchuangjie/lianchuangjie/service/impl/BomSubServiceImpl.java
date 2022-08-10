package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.BomSubEntity;
import com.lianchuangjie.lianchuangjie.service.BomSubService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
@Service
public class BomSubServiceImpl implements BomSubService {
    @Override
    public boolean saveBatch(Collection<BomSubEntity> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<BomSubEntity> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<BomSubEntity> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(BomSubEntity entity) {
        return false;
    }

    @Override
    public BomSubEntity getOne(Wrapper<BomSubEntity> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<BomSubEntity> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<BomSubEntity> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<BomSubEntity> getBaseMapper() {
        return null;
    }

    @Override
    public Class<BomSubEntity> getEntityClass() {
        return null;
    }
}
