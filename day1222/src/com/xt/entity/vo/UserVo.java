package com.xt.entity.vo;

import com.xt.entity.Order;
import com.xt.entity.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 11:10
 * @since V1.00
 */
@Data
@ToString(callSuper = true)
public class UserVo extends User {
    private List<Order> orders;
}
