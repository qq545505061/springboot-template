package com.li.service;

import com.li.entity.Order;
import com.li.util.Page;

import java.util.List;

public interface OrderService {

    List<Order> getOrderByPage(Integer pageNum, Integer pageSize);
}
