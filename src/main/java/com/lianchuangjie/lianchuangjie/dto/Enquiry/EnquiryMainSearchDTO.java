package com.lianchuangjie.lianchuangjie.dto.Enquiry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 询价单主表查询条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryMainSearchDTO {
    // 页码
    @NotNull(message = "页码不能为空")
    private Integer page;
    // 每页显示数量 最大值为50
    @NotNull(message = "每页显示数量不能为空")
    @Max(value = 50, message = "每页最多显示50条数据")
    private Integer size;
    // 销售员编号,当前登录销售编号
    private Long ownerCode;
    // 询价单位编号
    private String cardCode;
    // 处理情况-销售报价次数
    @JsonProperty("U_State")
    private Integer uState;
    // 失效时间上限
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date invalidDateStart;
    // 失效时间下限
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date invalidDateEnd;
    // 发送时间上限
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inquiryDateStart;
    // 发送时间下限
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inquiryDateEnd;
    // 询价来源
    @JsonProperty("U_SourceType")
    private String uSourceType;
}
