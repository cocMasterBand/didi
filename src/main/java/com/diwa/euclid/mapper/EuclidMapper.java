package com.diwa.euclid.mapper;

import com.diwa.euclid.model.Euclid;

import java.util.List;

public interface EuclidMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Euclid record);

    int insertSelective(Euclid record);

    Euclid selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Euclid record);

    int updateByPrimaryKey(Euclid record);

    int insertBatch(List<Euclid> list);
}