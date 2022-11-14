package com.lianchuangjie.lianchuangjie.entity.Enquiry;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_BOM")
public class BomMainEntity {
    // 文件编号-主键 DocEntry
    @TableId(type = IdType.AUTO, value = "DocEntry")
    private Long docEntry;
    // 关联询价单编号
    @TableField(value = "BaseEntry")
    private Long baseEntry;
    // 上传时间
    @TableField(fill = FieldFill.INSERT, value = "CreateTime")
    private Date createTime;
    // 原文件名
    @TableField(value = "FileName")
    private String fileName;
    // 原文件存储位置
    @TableField(value = "Location")
    private String location;
    // 销售员编号
    @TableField(value = "OwnerCode")
    private Long ownerCode;
}
