package com.xt.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 10:30
 * @since V1.00
 */
@Data
public class Borrow {
    private Integer rid;
    private Integer bid;
    private Date lendDate;
    private Date willDate;
    private Date returnDate;
}

