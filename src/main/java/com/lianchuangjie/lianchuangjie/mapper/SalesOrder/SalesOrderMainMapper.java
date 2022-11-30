package com.lianchuangjie.lianchuangjie.mapper.SalesOrder;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderMainEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SalesOrderMainMapper extends BaseMapper<SalesOrderMainEntity> {
}
