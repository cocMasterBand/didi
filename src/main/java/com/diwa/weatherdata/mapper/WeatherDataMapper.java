package com.diwa.weatherdata.mapper;

import com.diwa.weatherdata.model.WeatherData;

import java.sql.Timestamp;
import java.util.List;

public interface WeatherDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeatherData record);

    int insertSelective(WeatherData record);

    WeatherData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeatherData record);

    int updateByPrimaryKey(WeatherData record);

    List<WeatherData> selectAll();

    List<WeatherData> selectByDate(String timestamp);
}