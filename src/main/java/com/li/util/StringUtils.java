package com.li.util;

/**
 * @author longxiong
 * 字符串工具类
 */
public class StringUtils {

    /**
    * 判断字符串是否为null和空串
    **/
    public static boolean stringIsEmpty(String str) {
        if (null == str || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

}
