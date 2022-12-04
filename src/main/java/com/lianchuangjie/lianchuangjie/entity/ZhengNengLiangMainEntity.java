package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_OZNL")
public class ZhengNengLiangMainEntity {
    @TableId(value = "DocEntry")
    private BigInteger docEntry;
}
