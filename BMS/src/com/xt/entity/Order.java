package com.xt.entity;

import lombok.Data;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/20 08:56
 * @since V1.00
 */
@Data
public class Order {
    private Integer oid;
    private Integer uid;
    private String address;
    private Float summary;

}
