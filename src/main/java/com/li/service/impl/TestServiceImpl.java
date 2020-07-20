package com.li.service.impl;

import com.li.annotation.NeedSetFieldValue;
import com.li.controller.TestController;
import com.li.dao.TestMapper;
import com.li.entity.Order;
import com.li.entity.User;
import com.li.exception.SQLErrorException;
import com.li.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author longxiong
 **/
@Service
public class TestServiceImpl implements TestService {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private TestMapper testMapper;

    @Override
    public int test() throws SQLErrorException {
        int a = testMapper.test();
        System.out.println(a);
        logger.info("test-------------");
        throw new SQLErrorException("SQL异常");
    }

    @Override
    public User getUserById(Integer id) {
        User user = testMapper.selectUserById(id);
        return user;
    }

    @NeedSetFieldValue
    @Override
    public List<Order> getOrderByState(Integer state) {
        List<Order> list = testMapper.selectOrderByState(state);
        return list;
    }
}
