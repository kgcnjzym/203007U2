package com.xt.dao;

import com.xt.entity.Order;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/20 09:02
 * @since V1.00
 */
public interface OrderDao {
    /**
     * 添加订单
     * @param order
     * @return
     */
    int insert(Order order);

    /**
     * 根据订单编号、用户id查找订单
     * @param oid
     * @param uid
     * @return
     */
    Order selectByIdUser(Integer oid,Integer uid);

    /**
     * 根据订单编号删除订单
     * @param oid
     * @return
     */
    int delete(Integer oid);

    /**
     * 根据用户查找订单
     * @param uid
     * @return
     */
    List<Order> selectByUser(Integer uid);
}
