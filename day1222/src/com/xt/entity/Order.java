package com.xt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:57
 * @since V1.00
 */
@Data
public class Order implements Serializable {

    private Integer oid;
    private Integer uid;
    private String address;
    private Float summary;
}
