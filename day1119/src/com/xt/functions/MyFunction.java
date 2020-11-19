package com.xt.functions;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义函数标签类
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/19 12:12
 * @since V1.00
 */
public class MyFunction {
    public static String hello(String name){
        return "Hello,"+name;
    }

    public static List<String> getNames(){
        List<String> lst=new ArrayList<>();
        lst.add("tom");
        lst.add("andy");
        lst.add("mike");
        lst.add("jerry");
        return lst;
    }
}
