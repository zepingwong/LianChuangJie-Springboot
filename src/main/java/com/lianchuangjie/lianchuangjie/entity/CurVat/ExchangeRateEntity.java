package com.lianchuangjie.lianchuangjie.entity.CurVat;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @description  汇率表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_ORTT")
public class ExchangeRateEntity {
    /**
     * @description 日期
     */
    @TableField(value = "RateDate")
    private Date rateDate;
    /**
     * @description 货币
     */
    @TableField(value = "Currency")
    private String currency;
    /**
     * @description 汇率
     */
    @TableField(value = "Rate")
    private BigDecimal rate;
}
