package com.lianchuangjie.lianchuangjie.vo.Quotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TabQuotationSdadaVO {
    @JsonProperty("id")
    private Long id;
    /**
     * @description 型号 sno
     */
    @JsonProperty("sno")
    private String sno;
    /**
     * @description 类型 type
     */
    @JsonProperty("type")
    private String type;
    /**
     * @description 包装 packing
     */
    @JsonProperty("packing")
    private String packing;
    /**
     * @description SPQ
     */
    @JsonProperty("spq")
    private String spq;
    /**
     * @description RoHS-是否环保 rohs
     */
    @JsonProperty("rohs")
    private String rohs;
    /**
     * @description 技术资料URL datasheet
     */
    @JsonProperty("datasheet")
    private String datasheet;
    /**
     * @description ECCN
     */
    @JsonProperty("ECCN")
    private String eccn;
    /**
     * @description 品牌名称 QuoBrand
     */
    @JsonProperty("QuoBrand")
    private String quoBrand;

    /**
     * @description 封装 package
     */
    @JsonProperty("package")
    private String packages;
    /**
     * @description 湿度等级
     */
    @JsonProperty("msl_new")
    private String mslNew;
    /**
     * @description 型号标签
     */
    @JsonProperty("tag")
    private String tag;
}
