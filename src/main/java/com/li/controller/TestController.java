package com.li.controller;

import com.li.base.RestBaseController;
import com.li.exception.SQLErrorException;
import com.li.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("test")
public class TestController extends RestBaseController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private TestService testService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test() throws SQLErrorException {
        int rst = testService.test();
        sendData(State.Success, "OK", rst);
    }
}
