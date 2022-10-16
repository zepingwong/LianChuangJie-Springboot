package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.EnquirySaveItemDTO;
import com.lianchuangjie.lianchuangjie.dto.search.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.dto.search.TabSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquirySubService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquirySubVO;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.TabEnquiryNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.Quotation.TabQuotationNeedsVO;
import com.lianchuangjie.lianchuangjie.vo.StockPrice.TabStockPriceEnquiryVO;
import com.lianchuangjie.lianchuangjie.vo.TabSearchNeedsVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnquirySubServiceImpl extends ServiceImpl<EnquirySubMapper, EnquirySubEntity> implements EnquirySubService {
    @Resource
    EnquirySubMapper enquirySubMapper;
    @Value("${algorithm_address}")
    String address;

    /**
     * @param searchCondition searchCondition
     * @return List
     * @description 获取询价单子表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    @Override
    public Page<EnquirySubVO> list(EnquirySubSearchDTO searchCondition) {
        Page<EnquirySubVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        enquirySubMapper.selectList(page, searchCondition);
        //        JSONObject json = new JSONObject();
        //        json.put("data", list);
        //        String res;
        //        try {
        //            res = HttpUtil.jsonPost(address + "main", null, json);
        //            JSONObject object = JSONObject.parseObject(res);
        //            return JSON.parseArray(object.getString("data"), EnquirySubVO.class);
        //        } catch (IOException e) {
        //            throw new RuntimeException(e);
        //        }
        return page;
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
    public Page<TabSearchNeedsVO> searchTabList(TabSearchDTO searchCondition) {
        Page<TabSearchNeedsVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        page.addOrder(OrderItem.desc("T_ICIN.InquiryDate"));
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        page.setRecords(enquirySubMapper.selectSearchTabList(searchCondition));
        page.setTotal(enquirySubMapper.countEnquiryTabList(searchCondition));
        return page;
    }

    @Override
    public Page<TabStockPriceEnquiryVO> stockTabList(TabSearchDTO searchCondition) {
        Page<TabStockPriceEnquiryVO> page = Page.of(searchCondition.getPage(), searchCondition.getSize());
        enquirySubMapper.selectStockPriceTabList(page, searchCondition);
        return page;
    }

    @Override
    public Boolean saveOne(EnquirySaveItemDTO enquirySaveItemDTO) {
        QueryWrapper<EnquirySubEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DocEntry", enquirySaveItemDTO.getDocEntry());
        queryWrapper.eq("LineNum", enquirySaveItemDTO.getLineNum());
        EnquirySubEntity enquirySubEntity = enquirySubMapper.selectOne(queryWrapper);
        enquirySubEntity.setBaseEntry(enquirySaveItemDTO.getBaseEntry()); // 货源信息
        enquirySubEntity.setBaseLine(enquirySaveItemDTO.getBaseLine()); // 货源信息
        if (enquirySubEntity.getBaseEntry() != null & enquirySubEntity.getBaseLine() != null) {
            // 已经存过货源信息了,接下来存多个货源
            Long lineNum = enquirySubMapper.count(enquirySaveItemDTO.getDocEntry()) + 1L;
            enquirySubEntity.setLineNum(lineNum); // LineNum 只能继续增加
            enquirySubEntity.setItemEntry(enquirySaveItemDTO.getDocEntry()); // 多个货源的需求信息检索
            enquirySubEntity.setItemLine(enquirySaveItemDTO.getLineNum()); // 多个货源的需求信息检索
            enquirySubMapper.insert(enquirySubEntity);
        } else {
            enquirySubMapper.updateOne(enquirySubEntity);
        }
        return true;
    }
}
