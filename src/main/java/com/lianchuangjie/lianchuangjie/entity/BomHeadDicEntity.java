package com.lianchuangjie.lianchuangjie.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("T_BOHD")
@Component
public class BomHeadDicEntity {
    private Integer Id;
    // 型号别名，每个别名用逗号隔开
    private String Modle;
    @TableField(exist = false)
    private List<String> ModleList;
    // 品牌别名，每个别名用逗号隔开
    private String Brand;
    @TableField(exist = false)
    private List<String> brandList;
    // 数量别名，每个别名用逗号隔开
    private String Quantity;
    @TableField(exist = false)
    private List<String> quantityList;
    // 备注别名，每个别名用逗号隔开
    private String Remark;
    @TableField(exist = false)
    private List<String> remarkList;

    public List<String> getModleList() {
        return Arrays.asList(Modle.split(","));
    }

    public List<String> getBrandList() {
        return Arrays.asList(Brand.split(","));
    }

    public List<String> getQuantityList() {
        return Arrays.asList(Quantity.split(","));
    }

    public List<String> getRemarkList() {
        return Arrays.asList(Remark.split(","));
    }
}
