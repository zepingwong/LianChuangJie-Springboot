package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @description 业务合作伙伴（客户、供应商）性质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_OCRG")
public class ClienteleGroupEntity {
    // 业务合作伙伴性质代码
    private Integer Code;
    // 业务合作伙伴性质名称
    private String Name;
    // 业务合作伙伴性质：供应商/客户
    private String Type;
     // 业务合作伙伴性质简称
    private String uShortName;
}
