package com.lianchuangjie.lianchuangjie.dto.Enquiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Bom单上传记录查询条件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BomMainSearchDTO {
    // 页码
    @NotNull(message = "页码不能为空")
    private Integer page;
    // 每页显示数量 最大值为50
    @NotNull(message = "每页显示数量不能为空")
    private Integer size;
    private Long ownerCode;
    private Date createTimeStart;
    private Date createTimeEnd;
}
