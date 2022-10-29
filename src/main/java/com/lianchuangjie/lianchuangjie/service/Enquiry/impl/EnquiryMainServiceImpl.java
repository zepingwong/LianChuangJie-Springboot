package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.exception.Business.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquiryMainService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMainInfoVO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquiryMainItemVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnquiryMainServiceImpl extends ServiceImpl<EnquiryMainMapper, EnquiryMainEntity> implements EnquiryMainService {
    @Resource
    EnquiryMainMapper enquiryMainMapper;

    @Override
    public EnquiryMainInfoVO getOne(Long docEntry) {
        QueryWrapper<EnquiryMainEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DocEntry", docEntry);
        // 判断询价单是否存在
        ResponseEnum.ISNULL.assertIsFalse(
                enquiryMainMapper.exists(queryWrapper),
                "编号为" + docEntry + "的询价单不存在"
        );
        Long userSign = SessionUtil.getUser().getUserSign();
        EnquiryMainEntity enquiryMainEntity = enquiryMainMapper.selectByDocEntry(docEntry, userSign);
        // 判断权限
        ResponseEnum.HAS_NO_AUTHENTICATION.assertNotNull(
                enquiryMainEntity,
                "您没有权限查看编号为" + docEntry + "的询价单"
        );
        EnquiryMainInfoVO enquiryMain = new EnquiryMainInfoVO();
        BeanUtils.copyProperties(enquiryMainEntity, enquiryMain);
        return enquiryMain;
    }

    @Override
    public Page<EnquiryMainItemVO> getList(EnquiryMainSearchDTO searchCondition) {
        Page<EnquiryMainItemVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        String mainTable = SqlHelper.table(EnquiryMainEntity.class).getTableName();
        page.addOrder(OrderItem.desc(mainTable + ".CreateDate"));
        // 设置分页查询结果
        page.setRecords(enquiryMainMapper.selectList(searchCondition));
        // 查询结果总条数
        page.setTotal(enquiryMainMapper.countList(searchCondition));
        return page;
    }
}
