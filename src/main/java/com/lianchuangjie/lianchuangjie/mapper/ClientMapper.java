package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.vo.ClientInfoVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientMapper extends BaseMapper<ClienteleEntity> {
    List<ClienteleItemVO> queryByCardName(
            @Param("CardName") String CardName,
            @Param("UserSign") Long UserSign
    );

    ClientInfoVO queryByCardCode(
            @Param("CardCode") String CardCode,
            @Param("UserSign") Long UserSign
    );
}
