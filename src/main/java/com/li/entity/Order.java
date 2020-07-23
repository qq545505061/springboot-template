package com.li.entity;

import com.li.annotation.FieldSetValue;
import com.li.annotation.SetFieldValue;
import com.li.dao.TestMapper;
import com.li.dao.UserMapper;

public class Order {

    private Integer id;
    private String orderNo;
    private Integer userId;
    private Integer goodsId;
    @FieldSetValue(beanClass =UserMapper.class, method = "selectUserById", param = "userId", targetField = "name")
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
