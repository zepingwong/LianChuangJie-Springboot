package com.lianchuangjie.lianchuangjie.entity.Enquiry;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_BomDic")
public class BomHeadDicEntity {
    @TableId(value = "DocEntry")
    private Long docEntry;
    @TableField(value = "DicKey")
    private String dicKey;
    @TableField(value = "Value")
    private String value;
    @TableField(value = "CreateDate")
    private Date createDate;
    @TableField(value = "UpdateDate")
    private Date updateDate;
}
