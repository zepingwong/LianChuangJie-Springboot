package com.lianchuangjie.lianchuangjie.entity.YunHan;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_LIPR1")
public class YunHanEntity {
    @TableField(value = "DocEntry")
    private Long docEntry;
    @TableField(value = "LineNum")
    private Long lineNum;
    // 型号
    @TableField(value = "keyword")
    private String keyword;
    // 品牌
    @TableField(value = "pro_maf")
    private String proMaf;
    // 数量
    @TableField(value = "pro_num")
    private BigDecimal proNum;
    // 查询时间
    @TableField(value = "CreateDate")
    private Date createDate;
    @TableField(value = "TargetLine")
    private Long targetLine;
    @TableField(value = "BaseEntry")
    private Long baseEntry;
    @TableField(value = "BaseLine")
    private Long baseLine;
    @TableField(value = "LIPG")
    private String lipg;
    @TableField(value = "LIPS")
    private String lips;
}
