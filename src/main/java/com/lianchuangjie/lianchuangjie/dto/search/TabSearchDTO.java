package com.lianchuangjie.lianchuangjie.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lianchuangjie.lianchuangjie.utils.SessionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
        return SessionUtil.getUserSign();
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
}
