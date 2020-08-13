package com.itutry.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {

    public static <T> T mapToBean(Map map, Class<T> type) {
        try {
            T bean = type.newInstance();
            BeanUtils.populate(bean, map);
            System.out.println(bean);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int parseInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }
}
