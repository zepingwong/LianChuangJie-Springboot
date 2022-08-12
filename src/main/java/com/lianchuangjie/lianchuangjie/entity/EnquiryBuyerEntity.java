package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 采购询价转发规则
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_PUR1")
public class EnquiryBuyerEntity {
    /**
     * @description 采购员代码
     */
    @TableField(value = "OwnerCode")
    private Long ownerCode;
    /**
     * @description 采购员姓名
     */
    @TableField(exist = false)
    private String userName;
    /**
     * @description 部门编号
     */
    @TableField(value = "DeptCode")
    private String deptCode;
    /**
     * @description IsSale
     */
    @TableField(value = "IsSale")
    private String isSale;
    /**
     * @description StartTotal 报价起点
     */
    @TableField(value = "StartTotal")
    private BigDecimal startTotal;
    /**
     * @description ECCN
     */
    @TableField(value = "ECCN")
    private String eccn;
}
