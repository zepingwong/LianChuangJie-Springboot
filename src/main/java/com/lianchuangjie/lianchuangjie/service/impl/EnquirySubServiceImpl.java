package com.lianchuangjie.lianchuangjie.service.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.EnquirySaveItemDTO;
import com.lianchuangjie.lianchuangjie.dto.EnquirySubItemDTO;
import com.lianchuangjie.lianchuangjie.dto.search.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.EnquirySubService;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import com.lianchuangjie.lianchuangjie.vo.EnquirySubVO;
import com.lianchuangjie.lianchuangjie.vo.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.TabQuotationNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.TabStockPriceEnquiryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnquirySubServiceImpl extends ServiceImpl<EnquirySubMapper, EnquirySubEntity> implements EnquirySubService {
    @Resource
    EnquirySubMapper enquirySubMapper;

    /**
     * @param docEntry docEntry
     * @return List
     * @description 获取询价单子表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    @Override
    public List<EnquirySubVO> list(Long docEntry) {
        Long userSign = SessionUtil.getUserSign();
        EnquirySubSearchDTO enquirySubSearchDTO = new EnquirySubSearchDTO();
        enquirySubSearchDTO.setDocEntry(docEntry);
        enquirySubSearchDTO.setOwnerCode(userSign);
        return enquirySubMapper.selectList(enquirySubSearchDTO);
    }

    /**
     * @return Boolean
     * @description 保存接口
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    @Override
    public Boolean save(List<EnquirySaveItemDTO> enquirySubList) {
        // 两层循环,第一次时询价表,第二层时货源
        for (EnquirySaveItemDTO enquirySaveItemDTO : enquirySubList) {
            EnquirySubEntity enquirySubEntity = enquirySubMapper.selectOne(enquirySaveItemDTO.getDocEntry(), enquirySaveItemDTO.getLineNum());
            enquirySubMapper.clear(enquirySaveItemDTO.getDocEntry(), enquirySaveItemDTO.getLineNum());
            int i = 0;
            for (EnquirySubItemDTO enquirySubItemDTO : enquirySaveItemDTO.getRecommend()) {
                 BeanUtils.copyProperties(enquirySubItemDTO, enquirySubEntity);
                if (i == 0) {
                    // 第一条对应的是原始需求的货源,需要 update
                    enquirySubMapper.updateOne(enquirySubEntity);
                } else {
                    // 其他的时选择的多个货源, 需要 insert,行号需要增长
                    Long lineNum = enquirySubMapper.count(enquirySubItemDTO.getDocEntry()) + 1L;
                    enquirySubEntity.setLineNum(lineNum);
                    enquirySubEntity.setItemEntry(enquirySubEntity.getDocEntry()); // ItemEntry 与 DocEntry 相同
                    enquirySubEntity.setItemLine(enquirySubEntity.getLineNum()); // ItemLine 与 LineNum 相同
                    enquirySubMapper.insert(enquirySubEntity);
                }
                i += 1;
            }
        }
        return true;
    }

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 采购报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @Override
    public Page<TabQuotationNeedsVO> quotationTabList(TabSearchDTO searchCondition) {
        Page<TabQuotationNeedsVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN.InquiryDate"));
        enquirySubMapper.selectQuotationTabList(page, searchCondition);
        return page;
    }

    /**
     * @param searchCondition searchCondition
     * @return Page
     * @description 销售报价页面-客户需求TAB
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/20/2022
     */
    @Override
    public Page<TabEnquiryNeedsVO> enquiryTabList(TabSearchDTO searchCondition) {
        Page<TabEnquiryNeedsVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN.InquiryDate"));
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        page.setRecords(enquirySubMapper.selectEnquiryTabList(searchCondition));
        page.setTotal(enquirySubMapper.countEnquiryTabList(searchCondition));
        return page;
    }

    @Override
    public Page<TabStockPriceEnquiryVO> stockTabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceEnquiryVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        enquirySubMapper.selectStockPriceTabList(page, searchCondition);
        return page;
    }
}
