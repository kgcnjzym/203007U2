package com.xt.service;

import com.xt.entity.vo.OrderVo;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/23 10:33
 * @since V1.00
 */
public interface OrderService {
    /**
     * 查询所有订单
     * @return
     */
    List<OrderVo> getAll();
}
