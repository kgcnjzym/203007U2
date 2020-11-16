package com.xt.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/16 09:55
 * @since V1.00
 */
@Data
public class Penalty {
    private Integer userId;
    private Integer bookId;
    private Date date;
    private Integer type;
    private Float amount;
}
