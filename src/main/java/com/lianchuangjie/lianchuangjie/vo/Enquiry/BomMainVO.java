package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long docEntry;
    // 关联询价单编号
    @JsonProperty("BaseEntry")
    private Long baseEntry;
    // 上传时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("CreateTime")
    private Date createTime;
    // 原文件名
    @JsonProperty("FileName")
    private String fileName;
    // 原文件存储位置
    @JsonProperty("Location")
    private String location;
    // 销售员编号
    @JsonProperty("OwnerCode")
    private Long ownerCode;
    // 销售员姓名
    @JsonProperty("UserName")
    private String userName;
}
