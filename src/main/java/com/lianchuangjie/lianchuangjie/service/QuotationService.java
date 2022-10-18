package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.QuotationReplyDTO;
import com.lianchuangjie.lianchuangjie.dto.search.QuotationSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.QuotationEntity;
import com.lianchuangjie.lianchuangjie.vo.Quotation.QuotationVO;

public interface QuotationService extends IService<QuotationEntity> {
    /**
     * @param quotationReplyDTO quotationReplyDTO
     * @return Boolean
     * @description 采购回复
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    Boolean reply(QuotationReplyDTO quotationReplyDTO);

    /**
     * @param queryWrapper queryWrapper
     * @return QuotationEntity
     * @description 查询一条采购报价信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    QuotationEntity getOne(QueryWrapper<QuotationEntity> queryWrapper);
    /**
     * @param quotationSearchDTO 采购报价列表查询
     * @return QuotationEntity
     * @description 查询一条采购报价信息
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    Page<QuotationVO> getList(QuotationSearchDTO quotationSearchDTO);
}
