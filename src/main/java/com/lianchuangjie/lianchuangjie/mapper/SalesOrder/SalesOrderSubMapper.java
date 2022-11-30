package com.lianchuangjie.lianchuangjie.mapper.SalesOrder;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SalesOrderSubMapper extends BaseMapper<SalesOrderSubEntity> {

}
