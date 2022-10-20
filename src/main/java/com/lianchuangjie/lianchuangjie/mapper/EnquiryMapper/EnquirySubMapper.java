package com.lianchuangjie.lianchuangjie.mapper.EnquiryMapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lianchuangjie.lianchuangjie.dto.Enquiry.EnquirySubSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.EnquirySubEntity;
import com.lianchuangjie.lianchuangjie.vo.Enquiry.EnquirySubVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportHeadVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryExportItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnquirySubMapper extends BaseMapper<EnquirySubEntity> {
    Integer count(@Param("DocEntry") Long docEntry);

    /**
     * @param enquirySubEntity enquirySubEntity
     * @return Boolean
     * @description 更新一条货源，更新的就是原始需求那一条
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    Boolean updateOne(@Param("Entity") EnquirySubEntity enquirySubEntity);

    /**
     * @param enquirySubEntity enquirySubEntity
     * @return Boolean
     * @description 更采购员发一个确认
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/20/2022
     */
    Boolean updateBuyers(@Param("Entity") EnquirySubEntity enquirySubEntity);

    EnquirySubEntity selectOne(@Param("ew") QueryWrapper<EnquirySubEntity> queryWrapper);

    /**
     * @return List
     * @description 获取询价单子表列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/19/2022
     */
    IPage<EnquirySubVO> selectList(IPage<EnquirySubVO> page, @Param("sc") EnquirySubSearchDTO enquirySIbSearchDTO);

    Boolean clear(@Param("DocEntry") Long docEntry, @Param("LineNum") Long lineNum);



    Boolean order(@Param("Entity") EnquirySubEntity enquirySubEntity);

    /**
     * @param enquirySubSearchDTO enquirySubSearchDTO
     * @return List
     * @description 查询报价单导出列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/25/2022
     */
    List<EnquiryExportItemVO> selectExportList(@Param("sc") EnquirySubSearchDTO enquirySubSearchDTO);

    /**
     * @param enquirySubSearchDTO enquirySubSearchDTO
     * @return List
     * @description 查询报价单列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/29/2022
     */
    List<EnquiryExportItemVO> selectQuoteList(@Param("sc") EnquirySubSearchDTO enquirySubSearchDTO);

    EnquiryExportHeadVO head(@Param("sc") EnquirySubSearchDTO enquirySubSearchDTO);
}
