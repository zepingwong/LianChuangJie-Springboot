package com.lianchuangjie.lianchuangjie.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HomeMapper {
    @MapKey("DocEntry")
    List<Map<String, String>> querySalesRank();

    @MapKey("DocEntry")
    List<Map<String, String>> queryMonthSales();

    @MapKey("DocEntry")
    List<Map<String, String>> getYearSales();
}
