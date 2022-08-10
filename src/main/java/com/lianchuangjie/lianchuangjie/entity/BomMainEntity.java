package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_BOM")
public class BomMainEntity {
    // 文件编号-主键 DocEntry
    private Long DocEntry;
    // 关联询价单编号
    private Long BaseEntry;
    // 上传时间
    private Date UploadTime;
    // 原文件名
    private String FileName;
    // 原文件存储位置
    private String Location;
    // 销售员编号
    private Long OwnerCode;
}
