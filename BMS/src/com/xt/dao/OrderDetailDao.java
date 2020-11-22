package com.xt.dao;

import com.xt.entity.OrderDetail;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/20 09:02
 * @since V1.00
 */
public interface OrderDetailDao {
    /**
     * 添加订单详情
     * @param orderDetail
     * @return
     */
    int insert(OrderDetail orderDetail);

    /**
     * 根据订单编号查找订单详情
     * @param oid
     * @return
     */
    List<OrderDetail> selectByOrder(Integer oid);

    /**
     * 根据订单编号删除订单详情
     * @param oid
     * @return
     */
    int deleteByOrder(Integer oid);
}
