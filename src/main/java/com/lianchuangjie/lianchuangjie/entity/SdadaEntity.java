package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description 标准型号表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("SDADA")
public class SdadaEntity {
    @TableField(value = "id")
    private Long id;
    /**
     * @description 型号 sno
     */
    @TableField(value = "sno")
    private String sno;
    /**
     * @description 类型 type
     */
    @TableField(value = "type")
    private String type;
    /**
     * @description 包装 packing
     */
    @TableField(value = "packing")
    private String packing;
    /**
     * @description SPQ
     */
    @TableField(value = "spq")
    private String spq;
    /**
     * @description RoHS-是否环保 rohs
     */
    @TableField(value = "rohs")
    private String rohs;
    /**
     * @description 技术资料URL datasheet
     */
    @TableField(value = "datasheet")
    private String datasheet;
    /**
     * @description ECCN
     */
    @TableField(value = "ECCN")
    private String eccn;
    /**
     * @description 品牌名称 QuoBrand
     */
    @TableField(value = "QuoBrand")
    private String quoBrand;
    /**
     * @description 封装 package
     */
    @TableField(value = "package")
    private String packages;
    /**
     * @description 湿度等级
     */
    @TableField(value = "msl_new")
    private String mslNew;
    /**
     * @description 型号标签
     */
    @TableField(value = "TAG")
    private String tag;
}
