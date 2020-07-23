package com.li.dao;

import com.li.entity.Order;
import com.li.util.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> selectOrdersByPage(Page<Order> page);

    Integer selectOrderCount();
}
