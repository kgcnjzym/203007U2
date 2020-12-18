package com.xt.entity;

import lombok.Data;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 11:18
 * @since V1.00
 */
@Data
public class OrderDetail {
    private Integer odid;
    private Integer oid;
    private Integer bid;
    private Integer quantity;
    private Float price;
}

