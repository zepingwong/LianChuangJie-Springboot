package com.lianchuangjie.lianchuangjie.dto.Enquiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquirySearchDTO {
    @NotNull(message = "页码不能为空")
    private Integer page;
    // 每页显示数量 最大值为50
    @NotNull(message = "每页显示数量不能为空")
    @Max(value = 50, message = "每页最多显示50条数据")
    private Integer size;
    /**
     * @description 需求型号 Modle
     */
    private String modle;
}
