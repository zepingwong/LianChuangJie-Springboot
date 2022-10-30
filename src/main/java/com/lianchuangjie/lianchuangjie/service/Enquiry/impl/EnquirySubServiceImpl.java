package com.lianchuangjie.lianchuangjie.service.Enquiry.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySaveItemDTO;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.Enquiry.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.mapper.Enquiry.EnquirySubMapper;
import com.lianchuangjie.lianchuangjie.service.Enquiry.EnquirySubService;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquirySubVO;
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
