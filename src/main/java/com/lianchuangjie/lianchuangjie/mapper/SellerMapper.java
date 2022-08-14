package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.vo.SellerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellerMapper {
    List<SellerVO> selectByBuyer(@Param("UserSign") Long userSign);
}
