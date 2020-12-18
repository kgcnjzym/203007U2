package com.xt.entity;

import lombok.Data;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 11:19
 * @since V1.00
 */
@Data
public class Order {
    private Integer id;
    private Integer uid;
    private String address;
    private Float summary;
}
