package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.BrandEntity;
import com.lianchuangjie.lianchuangjie.vo.BrandItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BrandMapper extends BaseMapper<BrandEntity> {
    List<BrandItemVO> selectByBuyer(@Param("UserSign") Long userSign);

    List<BrandItemVO> selectAll();
}
