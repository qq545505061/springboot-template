package com.li.controller;

import com.li.base.ControllerUtils;
import com.li.base.ResultCode;
import com.li.entity.Order;
import com.li.service.OrderService;
import com.li.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("getOrderByPage")
    public void getOrderByPage(Integer pageNum, Integer pageSize) {
        List<Order> orders = orderService.getOrderByPage(pageNum, pageSize);
        ControllerUtils.send(ResultCode.Success, orders);
    }
}
