package com.li.service;

import com.li.entity.Order;
import com.li.entity.User;
import com.li.exception.SQLErrorException;

import java.util.List;

public interface TestService {

    int test() throws SQLErrorException;

    User getUserById(Integer id);

    List<Order> getOrderByState(Integer state);
}
