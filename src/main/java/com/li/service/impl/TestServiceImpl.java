package com.li.service.impl;

import com.li.controller.TestController;
import com.li.dao.TestMapper;
import com.li.exception.SQLErrorException;
import com.li.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author longxiong
 **/
@Service
public class TestServiceImpl implements TestService {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private TestMapper testDao;

    @Override
    public int test() throws SQLErrorException {
        int a = testDao.test();
        System.out.println(a);
        logger.info("test-------------");
        throw new SQLErrorException("SQL异常");
    }
}
