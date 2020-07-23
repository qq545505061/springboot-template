package com.li.dao;

import com.li.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectUserById(Integer id);
}
