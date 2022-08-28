package com.lianchuangjie.lianchuangjie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.dto.search.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     * @param queryWrapper    queryWrapper
     * @param searchCondition searchCondition
     * @return List
     * @description 获取询价单主表列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    List<EnquiryMainItemVO> selectList(
            @Param("ew") QueryWrapper<EnquiryMainItemVO> queryWrapper,
            @Param("sc") EnquiryMainSearchDTO searchCondition
    );

    /**
     * @param queryWrapper    queryWrapper
     * @param searchCondition searchCondition
     * @return Integer
     * @description 获取询价单主表条数
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    Integer countList(
            @Param("ew") QueryWrapper<EnquiryMainItemVO> queryWrapper,
            @Param("sc") EnquiryMainSearchDTO searchCondition
    );

    /**
     * 查询最大的文档编号
     *
     * @return max docEntry
     */
    Long selectMaxDocEntry();

}
