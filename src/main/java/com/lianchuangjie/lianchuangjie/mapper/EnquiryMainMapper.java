package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.searchDTO.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
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

    IPage<EnquiryMainVO> selectList(
            IPage<EnquiryMainVO> page,
            @Param("searchDTO") EnquiryMainSearchDTO searchDTO
    );
}
