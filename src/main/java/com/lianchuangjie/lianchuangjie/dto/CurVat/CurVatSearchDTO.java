package com.lianchuangjie.lianchuangjie.dto.CurVat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurVatSearchDTO {
    private String type;
    private String currency;
    private List<String> typeList;

    public List<String> getTypeList() {
        return Arrays.asList(type.split(","));
    }

    private List<String> currencyList;

    public List<String> getCurrencyList() {
        return Arrays.asList(currency.split(","));
    }
    private String isDeleted;
}
