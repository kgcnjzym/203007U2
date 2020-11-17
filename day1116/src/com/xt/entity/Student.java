package com.xt.entity;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/17 10:07
 * @since V1.00
 */
public class Student {
    private String name;
    private Integer age;

    public Integer getMyAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public String getName() {
        System.out.println("this is getter of name");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
