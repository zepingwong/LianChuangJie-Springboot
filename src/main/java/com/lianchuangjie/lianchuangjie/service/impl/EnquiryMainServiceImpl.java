package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.searchDTO.EnquiryMainSearchDTO;
import com.lianchuangjie.lianchuangjie.service.EnquiryMainService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainInfoVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryMainItemVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnquiryMainServiceImpl extends ServiceImpl<EnquiryMainMapper, EnquiryMainEntity> implements EnquiryMainService {
    @Resource
    EnquiryMainMapper enquiryMainMapper;

    @Override
    public EnquiryMainInfoVO getOne(Long docEntry) {
        ResponseEnum.ISNULL.assertIsFalse(enquiryMainMapper.existByDocEntry(docEntry), "编号为" + docEntry + "的询价单不存在");
        Long userSign = SessionUtil.getUserSign();
        EnquiryMainEntity enquiryMainEntity = enquiryMainMapper.selectByDocEntry(docEntry, userSign);
        ResponseEnum.HAS_NO_AUTHENTICATION.assertNotNull(enquiryMainEntity, "您没有权限查看编号为" + docEntry + "的询价单");
        EnquiryMainInfoVO enquiryMain = new EnquiryMainInfoVO();
        BeanUtils.copyProperties(enquiryMainEntity, enquiryMain);
        return enquiryMain;
    }

    @Override
    public Page<EnquiryMainItemVO> list(EnquiryMainSearchDTO searchCondition) {
        Page<EnquiryMainItemVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN.CreateDate"));
        enquiryMainMapper.selectList(page, searchCondition);
        return page;
    }
}
