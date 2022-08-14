package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EnquiryMainMapper extends BaseMapper<EnquiryMainEntity> {
    /**
     * @param docEntry 单据编号
     * @param userSign 销售员编号
     * @return 询价单主表信息
     * @description 获取询价单主表信息
     */
    EnquiryMainEntity selectByDocEntry(
            @Param("DocEntry") Long docEntry,
            @Param("UserSign") Long userSign
    );

    /**
     * @param docEntry 文档编号
     * @return true/false
     * @description 判断编号为 docEntry 的询价单是否存在
     */
    Boolean existByDocEntry(@Param("DocEntry") Long docEntry);

    /**
     * 查询询价单主表列表
     *
     * @param page         分页查询
     * @param queryWrapper 查询条件
     * @return page
     */
    IPage<EnquiryMainItemVO> selectList(
            IPage<EnquiryMainItemVO> page,
            @Param("ew") QueryWrapper<EnquiryMainItemVO> queryWrapper
    );

    /**
     * 查询最大的文档编号
     *
     * @return max docEntry
     */
    Long selectMaxDocEntry();
}
