package com.diwa.poidata.mapper;

import com.diwa.poidata.model.PoiData;

public interface PoiDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoiData record);

    int insertSelective(PoiData record);

    PoiData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoiData record);

    int updateByPrimaryKey(PoiData record);
}