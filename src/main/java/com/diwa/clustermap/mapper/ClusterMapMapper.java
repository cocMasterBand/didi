package com.diwa.clustermap.mapper;

import com.diwa.clustermap.model.ClusterMap;

public interface ClusterMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClusterMap record);

    int insertSelective(ClusterMap record);

    ClusterMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClusterMap record);

    int updateByPrimaryKey(ClusterMap record);
}