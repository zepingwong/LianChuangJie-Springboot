package com.lianchuangjie.lianchuangjie.entity.Clientele;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务合作伙伴行业领域表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_OFIE")
public class ClienteleIndustryEntity {
    // 业务合作伙伴行业领域代码
    @TableId(value = "KeyCode")
    private String KeyCode;
    // 业务合作伙伴行业领域名称
    @TableField(value = "DomainName")
    private String DomainName;
    // 父级代码
    @TableField(value = "ParentCode")
    private String ParentCode;
}
