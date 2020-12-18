package com.xt.entity.vo;

import com.xt.entity.Order;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 13:30
 * @since V1.00
 */
@Data
@ToString(callSuper = true)
public class OrderVo extends Order {
    private List<OrderDetailVo> details;
}
