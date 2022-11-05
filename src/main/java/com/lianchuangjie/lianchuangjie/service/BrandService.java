package com.lianchuangjie.lianchuangjie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lianchuangjie.lianchuangjie.entity.BrandEntity;
import com.lianchuangjie.lianchuangjie.vo.BrandItemVO;
import com.lianchuangjie.lianchuangjie.vo.EnquiryBuyerItemVO;

import java.util.List;

public interface BrandService extends IService<BrandEntity> {
    /**
     * @param userSign userSign
     * @return List
     * @description 获取采购负责的品牌列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    List<BrandItemVO> list(Long userSign);

    /**
     * @return List
     * @description 获取所有的品牌
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/4/2022
     */
    List<BrandItemVO> all(String brand);

    /**
     * @param brand brand
     * @return List
     * @description 品牌模糊搜索建议
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 11/6/2022
     */
    List<BrandItemVO> containList(String brand);

    /**
     * @param brand brand
     * @return List
     * @description 获取该品牌的采购员列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 10/6/2022
     */
    List<EnquiryBuyerItemVO> getBuyers(String brand);
}
