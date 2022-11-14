package com.lianchuangjie.lianchuangjie.dto.Enquiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 字典查询条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BomHeadDictSearchDTO {
    // 页码
    @NotNull(message = "页码不能为空")
    private Integer page;
    // 每页显示数量 最大值为50
    @NotNull(message = "每页显示数量不能为空")
    private Integer size;
    private String key;
}
