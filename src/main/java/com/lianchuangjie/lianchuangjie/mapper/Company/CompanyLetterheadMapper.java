package com.lianchuangjie.lianchuangjie.mapper.Company;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianchuangjie.lianchuangjie.entity.CompanyLetterheadEntity;
import com.lianchuangjie.lianchuangjie.vo.CompanyLetterheadVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyLetterheadMapper extends BaseMapper<CompanyLetterheadEntity> {
    /**
     * @param UserSign UserSign
     * @return List
     * @description 获取公司抬头列表
     * @author WANG Zeping
     * @email zepingwong@gmail.com
     * @date 9/30/2022
     */
    List<CompanyLetterheadVO> selectList(
            @Param("UserSign") Long UserSign
    );
}
