package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.vo.ClienteleInfoVO;
import com.lianchuangjie.lianchuangjie.vo.ClienteleItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleClientMapper extends BaseMapper<ClienteleEntity> {
    List<ClienteleItemVO> selectList(
            @Param("CardName") String CardName,
            @Param("UserSign") Long UserSign
    );

    ClienteleInfoVO selectOne(
            @Param("CardCode") String CardCode,
            @Param("UserSign") Long UserSign
    );
}
