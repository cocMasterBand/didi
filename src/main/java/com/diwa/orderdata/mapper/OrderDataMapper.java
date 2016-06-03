package com.diwa.orderdata.mapper;

import com.diwa.orderdata.model.OrderData;

public interface OrderDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderData record);

    int insertSelective(OrderData record);

    OrderData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderData record);

    int updateByPrimaryKey(OrderData record);
}