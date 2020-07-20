package com.li.controller;

import com.li.base.ControllerUtils;
import com.li.base.ResultCode;
import com.li.entity.Order;
import com.li.entity.User;
import com.li.exception.SQLErrorException;
import com.li.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private TestService testService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test() throws SQLErrorException {
        int rst = testService.test();
        ControllerUtils.send(ResultCode.Success, rst);
    }

    @RequestMapping("getUserById")
    public void getUserById(Integer id) {
        User user = testService.getUserById(id);
    }

    @RequestMapping("getOrderByState")
    public void getOrderByState(Integer state) {
        List<Order> list = testService.getOrderByState(state);
        ControllerUtils.send(ResultCode.Success, list);
    }
}
