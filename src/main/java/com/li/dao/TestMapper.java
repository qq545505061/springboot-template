package com.li.dao;

import com.li.entity.Order;
import com.li.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    int test();

    User selectUserById(int id);

    List<Order> selectOrderByState(Integer state);

    User selectUserById(Integer id);
}
