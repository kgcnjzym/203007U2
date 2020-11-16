package com.xt.entity;

import lombok.Data;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/16 08:37
 * @since V1.00
 */
@Data
public class Message {
    private String from;
    private String to;
    private String content;
}
