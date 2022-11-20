package com.lianchuangjie.lianchuangjie.dto.StockList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockListSearchDTO {
    // 页码
    private Integer page;
    // 每页显示数量
    private Integer size;
    // 供应商编号
    private String cardCode;
    // 完成情况
    private String status;
    // 发送日期
    private Date createDateStart;
    private Date createDateEnd;
}
