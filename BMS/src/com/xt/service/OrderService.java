package com.xt.service;

import com.xt.entity.Book;
import com.xt.entity.Order;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/20 09:08
 * @since V1.00
 */
public interface OrderService {
    /**
     * 添加订单
     * @param uid
     * @param books
     * @return
     */
    int addOrder(Integer uid, List<Book> books);

    /**
     * 退货（删除订单）
     * @param order
     * @return
     */
    int deleteOrder(Order order);

    /**
     * 根据用户查找订单
     * @param uid
     * @return
     */
    List<Order> getByUser(Integer uid);
}
