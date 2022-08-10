package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.VatGroupEntity;
import com.lianchuangjie.lianchuangjie.vo.VatGroupVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VatGroupMapper extends BaseMapper<VatGroupEntity> {
    List<VatGroupVO> queryByType(@Param("Type") String Type);
}
