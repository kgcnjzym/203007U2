package com.xt.entity;

import lombok.Data;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/9 10:09
 * @since V1.00
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String gender;
    private Integer age;
    private Integer state;
    private String phone;
}
