package com.xt.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/6 11:04
 * @since V1.00
 */
@Data
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String pubComp;
    private Date pubDate;
    private Integer count;
    private Double price;
}
