package com.xt.entity;

import lombok.Data;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/26 14:04
 * @since V1.00
 */
@Data
public class Comment {
    private String title;
    private String content;
    private Integer id;
    private Integer uid;
    private Integer bid;
}
