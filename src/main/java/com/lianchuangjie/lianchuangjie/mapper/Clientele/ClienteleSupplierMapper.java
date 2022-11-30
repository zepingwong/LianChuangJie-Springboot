package com.lianchuangjie.lianchuangjie.mapper.Clientele;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.dto.Clientele.ClienteleSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Clientele.ClienteleEntity;
import com.lianchuangjie.lianchuangjie.vo.Clientele.ClienteleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClienteleSupplierMapper extends BaseMapper<ClienteleEntity> {
    /**
     * @param clienteleSearchDTO clienteleSearchDTO
     * @return List
     * @description 获取权限范围内供应商列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/30/2022
     */
    List<ClienteleVO> selectList(
            @Param("sc") ClienteleSearchDTO clienteleSearchDTO
    );

    /**
     * @param CardCode CardCode
     * @param UserSign UserSign
     * @return ClienteleVO
     * @description 获取单个供应商信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/30/2022
     */
    ClienteleVO selectOne(
            @Param("CardCode") String CardCode,
            @Param("UserSign") Long UserSign
    );
}
