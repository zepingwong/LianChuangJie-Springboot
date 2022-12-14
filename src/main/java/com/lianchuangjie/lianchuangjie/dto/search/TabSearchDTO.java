package com.lianchuangjie.lianchuangjie.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianchuangjie.lianchuangjie.utils.ContextUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TabSearchDTO {
    /**
     * @description 页码
     * @defaultValue 1
     */
    private Integer page;
    /**
     * @description 每页显示数量
     * @defaultValue 10
     * @maxValue 50
     */
    private Integer size;
    /**
     * @description 需求型号 Modle
     */
    private String modle;
    /**
     * @description 用户编号
     */
    private Long userSign;
    public Long getUserSign() {
        return ContextUtil.getUser().getUserSign();
    }
    /**
     * @description 需求型号数组 Modle
     */
    @JsonProperty("ModleList")
    private List<String> modleList;

    public List<String> getModleList() {
        if (modleList == null) {
            List<String> list = new ArrayList<>();
            list.add(modle);
            return list;
        } else {
            return modleList;
        }
    }
    /**
     * @description 批次
     */
    @JsonProperty("Year")
    private String year;
    /**
     * 库存定价页面会用到的现批次
     */
    @JsonProperty("Batch")
    private String batch;
    /**
     * 采购报价Tab-报价日期
     */
    @JsonProperty("QuoDateStart")
    private Date quoDateStart;
    @JsonProperty("QuoDateEnd")
    private Date quoDateEnd;
}
