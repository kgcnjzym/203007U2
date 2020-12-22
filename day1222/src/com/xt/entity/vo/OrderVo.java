package com.xt.entity.vo;

import com.xt.entity.Order;
import com.xt.entity.User;
import lombok.Data;
import lombok.ToString;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:58
 * @since V1.00
 */
@Data
@ToString(callSuper = true)
public class OrderVo extends Order {
    private User user;
}
