package com.diwa.weatherdata.mapper;

import com.diwa.weatherdata.model.WeatherData;

public interface WeatherDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeatherData record);

    int insertSelective(WeatherData record);

    WeatherData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeatherData record);

    int updateByPrimaryKey(WeatherData record);
}