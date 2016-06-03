package com.diwa.trafficdata.mapper;

import com.diwa.trafficdata.model.TrafficData;

public interface TrafficDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrafficData record);

    int insertSelective(TrafficData record);

    TrafficData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrafficData record);

    int updateByPrimaryKey(TrafficData record);
}