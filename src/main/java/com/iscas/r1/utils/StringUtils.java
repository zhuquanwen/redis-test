package com.iscas.r1.utils;

/**
 * @Author: zhuquanwen
 * @Description:
 * @Date: 2018/4/26 14:26
 * @Modified:
 **/
public class StringUtils {
    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
    public static boolean isNotEmpty(Object str) {
        return str != null && !"".equals(str);
    }
}
