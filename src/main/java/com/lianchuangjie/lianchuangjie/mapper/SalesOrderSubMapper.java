package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.SalesOrderSubEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SalesOrderSubMapper extends BaseMapper<SalesOrderSubEntity> {
    /**
     * @param cardName cardName
     * @return Boolean
     * @description 判断是否为老客户，只有下过单的才为老客户
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/28/2022
     */
    Boolean existByCardName(@Param("CardName") String cardName);
}
