package com.li.base;

/**
 * 返回结果状态码
 */
public enum ResultCode {
    //全局状态码
    Success(1), // 成功
    Fail(0), // 失败
    Error(-1), // 程序错误
    NoAuth(1000), // 没有认证
    NoLogin(1001),  // 获取用户信息失败，用户未登录
    NoRight(1002),  // 没有权限
    NoData(2000), // 没有获取到数据
    ReSubmit(3000);  // 重复操作

    private int code;
    ResultCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
