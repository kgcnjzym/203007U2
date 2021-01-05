package com.xt.entity;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/5 09:29
 * @since V1.00
 */
@Data
public class Seat {
    private Integer row;
    private Integer seats;
}
