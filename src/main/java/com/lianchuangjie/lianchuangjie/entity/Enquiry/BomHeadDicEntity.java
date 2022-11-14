package com.lianchuangjie.lianchuangjie.entity.Enquiry;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("U_BOHD")
public class BomHeadDicEntity {
    @TableField(value = "Id")
    private Integer id;
    // 型号别名，每个别名用逗号隔开
    @TableField(value = "Modle")
    private String modle;
    @TableField(exist = false)
    private List<String> ModleList;
    // 品牌别名，每个别名用逗号隔开
    @TableField(value = "Brand")
    private String brand;
    @TableField(exist = false)
    private List<String> brandList;
    // 数量别名，每个别名用逗号隔开
    @TableField(value = "Quantity")
    private String quantity;
    @TableField(exist = false)
    private List<String> quantityList;
    // 备注别名，每个别名用逗号隔开
    @TableField(value = "Remark")
    private String remark;
    @TableField(exist = false)
    private List<String> remarkList;

    public List<String> getModleList() {
        return Arrays.asList(modle.split(","));
    }

    public List<String> getBrandList() {
        return Arrays.asList(brand.split(","));
    }

    public List<String> getQuantityList() {
        return Arrays.asList(quantity.split(","));
    }

    public List<String> getRemarkList() {
        return Arrays.asList(remark.split(","));
    }
}
