package com.xt.entity;

import lombok.Data;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 09:37
 * @since V1.00
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone;
}
