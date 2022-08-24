package com.lianchuangjie.lianchuangjie.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @description 上传BOM单主表信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BomMainVO {
    // 文件编号-主键 DocEntry
    @JsonProperty("DocEntry")
    private Long DocEntry;
    // 关联询价单编号
    @JsonProperty("BaseEntry")
    private Long BaseEntry;
    // 上传时间
    @JsonProperty("UploadTime")
    private Date UploadTime;
    // 原文件名
    @JsonProperty("FileName")
    private String FileName;
    // 原文件存储位置
    @JsonProperty("Location")
    private String Location;
    // 销售员编号
    @JsonProperty("OwnerCode")
    private Long OwnerCode;
}
