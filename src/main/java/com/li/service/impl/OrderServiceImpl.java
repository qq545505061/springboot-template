package com.li.service.impl;

import com.li.annotation.NeedFieldSetValue;
import com.li.dao.OrderMapper;
import com.li.entity.Order;
import com.li.service.OrderService;
import com.li.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    @NeedFieldSetValue
    public List<Order> getOrderByPage(Integer pageNum, Integer pageSize) {
        Page<Order> page = new Page<>(pageNum, pageSize);
        List<Order> orders = orderMapper.selectOrdersByPage(page);
//        page.setData(orders);
//        page.setTotal(orderMapper.selectOrderCount());
        return orders;
    }
}
