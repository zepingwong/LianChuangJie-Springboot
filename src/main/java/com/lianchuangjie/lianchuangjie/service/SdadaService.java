package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.dto.search.SdadaSearchDTO;
import com.lianchuangjie.lianchuangjie.entity.SdadaEntity;
import com.lianchuangjie.lianchuangjie.vo.SdadaVO;

import java.util.List;

public interface SdadaService extends IService<SdadaEntity> {
    /**
     * @param modle modle
     * @return List
     * @description 标准型号的模糊搜索
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    List<SdadaVO> containList(String modle);

    /**
     * @param modle modle
     * @return List
     * @description 搜索关联型号
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 8/21/2022
     */
    List<SdadaVO> relatedList(String modle);

    /**
     * @param sdadaSearchDTO sdadaSearchDTO
     * @return Page
     * @description 获取标准型号列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/14/2022
     */
    Page<SdadaVO> list(SdadaSearchDTO sdadaSearchDTO);
}
