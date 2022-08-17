package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.entity.SdadaEntity;
import com.lianchuangjie.lianchuangjie.vo.SdadaVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SdadaMapper extends BaseMapper<SdadaEntity> {
    IPage<SdadaVO> selectTabList(IPage<SdadaVO> page, @Param("modleList") List<String> list);
}
