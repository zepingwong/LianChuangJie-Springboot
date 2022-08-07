package com.lianchuangjie.lianchuangjie.searchDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * 询价单主表查询条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryMainSearchDTO {
    /**
     * @description 页码
     * @defaultValue 1
     */
    @NotNull(message = "页码不能为空")
    private Integer page;
    /**
     * @description 每页显示数量
     * @defaultValue 10
     * @maxValue 50
     */
    @NotNull(message = "每页显示数量不能为空")
    @Max(value = 50,message = "每页最多显示50条数据")
    private Integer size;

    private Long OwnerCode;
}
