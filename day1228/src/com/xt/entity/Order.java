package com.xt.entity;

import lombok.Data;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 09:04
 * @since V1.00
 */
@Data
public class Order {
    private User user;
    private Integer id;
    private Integer[] books;
    private Map<String,Integer> carts;
    private Properties props;
    private Class<?> clz;
    private Date date;
}
