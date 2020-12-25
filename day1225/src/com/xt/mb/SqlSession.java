package com.xt.mb;

import java.lang.reflect.Proxy;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 09:34
 * @since V1.00
 */
public class SqlSession {
    public  static <T> T getDao(Class<T> clz){
        T obj= (T)Proxy.newProxyInstance(
                SqlSession.class.getClassLoader(),
                new Class<?>[]{clz},new SqlHandler());
        return obj;
    }
}
