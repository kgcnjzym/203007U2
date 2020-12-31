package com.xt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2020-12-22 10:11:19
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 723750551152117529L;

    private Integer id;

    private String name;

    private String password;

    private String email;

    private String gender;

    private Integer age;

    private String phone;

    private Integer point;

    private Integer state;




}