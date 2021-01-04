package com.xt.entity;

import lombok.Data;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/4 11:51
 * @since V1.00
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
}
