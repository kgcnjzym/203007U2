package com.xt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/29 09:54
 * @since V1.00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone;
}
