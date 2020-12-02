package com.xt.entity;

import lombok.Data;

/**
 * 用于组织AJAX数据的类型
 * data：数据
 * errorCode：错误码，0表示OK
 * message：提示信息
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/2 08:48
 * @since V1.00
 */
@Data
public class JsonData<T> {
    private T data;
    private Integer errorCode=0;
    private String message;
}
