package com.diwa.trafficdata.mapper;

import com.diwa.trafficdata.model.TrafficData;
import com.diwa.weatherdata.model.WeatherData;

import java.util.List;

public interface TrafficDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrafficData record);

    int insertSelective(TrafficData record);

    TrafficData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrafficData record);

    int updateByPrimaryKey(TrafficData record);

    List<TrafficData> selectAll();
}