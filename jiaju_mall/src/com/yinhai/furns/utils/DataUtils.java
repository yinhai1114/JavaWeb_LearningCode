package com.yinhai.furns.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author 银小海
 * @version 1.0
 * @email yinhai14@qq.com
 */
public class DataUtils {
    //将方法，封装到静态方法，方便使用
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseInt(String val, int defaultVal) {

        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            System.out.println(val + " 格式不正确...");
        }
        return defaultVal;
    }
}
