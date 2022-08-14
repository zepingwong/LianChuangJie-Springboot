package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 标准品牌库
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_OBRA")

public class BrandEntity {
    /**
     * @description 编号-主键 DocEntry
     */
    @TableField(value = "DocEntry")
    private Long docEntry;
    /**
     * @description Name 品牌名称
     */
    @TableField(value = "Name")
    private String name;
    /**
     * @description BrandName 品牌全称
     */
    @TableField(value = "BrandName")
    private String brandName;
    /**
     * @description OwnerCode 创建人
     */
    @TableField(value = "OwnerCode")
    private Long ownerCode;
    /**
     * @description Remark 备注
     */
    @TableField(value = "Remark")
    private String remark;
    /**
     * @description CreateDate 创建时间
     */
    @TableField(value = "CreateDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * @description BrandAlias 品牌别名
     */
    @TableField(value = "BrandAlias")
    private String brandAlias;
}
