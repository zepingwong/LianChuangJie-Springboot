package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lianchuangjie.lianchuangjie.entity.EnquiryMainEntity;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.exception.ResponseEnum;
import com.lianchuangjie.lianchuangjie.mapper.EnquiryMainMapper;
import com.lianchuangjie.lianchuangjie.dto.search.EnquiryMainSearchDTO;
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

        QueryWrapper<EnquiryMainItemVO> queryWrapper = new QueryWrapper<>();
        String mainTable = SqlHelper.table(EnquiryMainEntity.class).getTableName();
        String subTable = SqlHelper.table(EnquirySubEntity.class).getTableName();
        page.addOrder(OrderItem.desc(mainTable + ".CreateDate"));
        if (searchCondition.getCardCode() != null) {
            queryWrapper.eq(mainTable + ".CardCode", searchCondition.getCardCode());
        }
        if (searchCondition.getState() != null) {
            queryWrapper.eq(mainTable + ".State", searchCondition.getState());
        }
        if (searchCondition.getCreateDateStart() != null) {
            queryWrapper.ge(mainTable + ".CreateDate", searchCondition.getCreateDateStart());
        }
        if (searchCondition.getCreateDateEnd() != null) {
            queryWrapper.le(mainTable + ".CreateDate", searchCondition.getCreateDateEnd());
        }
        if (searchCondition.getInvalidDateStart() != null) {
            queryWrapper.ge(subTable + ".ExpDate", searchCondition.getInvalidDateStart());
        }
        if (searchCondition.getInvalidDateEnd() != null) {
            queryWrapper.le(subTable + ".ExpDate", searchCondition.getInvalidDateEnd());
        }
        queryWrapper.eq(mainTable + ".OwnerCode", searchCondition.getOwnerCode());
        enquiryMainMapper.selectList(page, queryWrapper);
        return page;
    }
}
