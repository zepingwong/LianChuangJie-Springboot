package com.lianchuangjie.lianchuangjie.dto.search;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
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
    /**
     * @description 页码
     */
    @NotNull(message = "页码不能为空")
    private Integer page;
    /**
     * @description 每页显示数量
     * @maxValue 50
     */
    @NotNull(message = "每页显示数量不能为空")
    @Max(value = 50, message = "每页最多显示50条数据")
    private Integer size;
    /**
     * @description 销售员编号
     * @defaultValue 当前登录用户编号
     */
    private Long ownerCode;

    public void setOwnerCode(Long ownerCode) {
        this.ownerCode = ownerCode != null ? ownerCode : SessionUtil.getUserSign();
    }

    /**
     * @description 询价单位编号
     */
    private String cardCode;
    /**
     * @description 处理情况-销售报价次数
     */
    private Integer state;
    /**
     * @description 失效时间上限
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date invalidDateStart;
    /**
     * @description 失效时间下限
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date invalidDateEnd;
    /**
     * @description 发送时间上限
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDateStart;
    /**
     * @description 发送时间下限
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDateEnd;
}
