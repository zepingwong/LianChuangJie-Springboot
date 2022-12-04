package com.lianchuangjie.lianchuangjie.vo.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @description 字典
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BomHeadDictVO {
    @JsonProperty("DocEntry")
    private Long docEntry;
    // 键值
    @JsonProperty("Value")
    private String value;
    // Key
    @JsonProperty("DicKey")
    private String dicKey;
    // 添加时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("CreateDate")
    private Date createDate;
    // 更新时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("UpdateDate")
    private Date updateDate;
}
