package com.diwa.orderdata.mapper;

import com.diwa.orderdata.model.OrderData;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

public interface OrderDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderData record);

    int insertSelective(OrderData record);

    OrderData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderData record);

    int updateByPrimaryKey(OrderData record);

    int insertBatch(List<OrderData> list);
}