package com.xt.dao;

import com.xt.entity.vo.OrderVo;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 13:33
 * @since V1.00
 */
public interface OrderDao {
    /**
     * 根据用户Id查找订单VO
     * @param id
     * @return
     */
    List<OrderVo> selectVosByUser(Integer id);
}
