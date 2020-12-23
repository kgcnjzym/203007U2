package com.xt.dao;

import com.xt.entity.Order;
import com.xt.entity.vo.OrderVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/22 10:59
 * @since V1.00
 */
@CacheNamespace
public interface OrderDao {
    /**
     * 根据订单编号查找
     * @param id
     * @return
     */
    @Select("select * from orders where oid=#{id}")
    @Results({
        @Result(column = "uid",property = "uid"),
        @Result(column = "uid",property = "user",
            one = @One(select = "com.xt.dao.UserDao.queryById"))
    })
    OrderVo selectById(Integer id);

    @Select("select * from orders ")
    @Results({
            @Result(column = "uid",property = "uid"),
            @Result(column = "uid",property = "user",
                    one = @One(select = "com.xt.dao.UserDao.queryById"))
    })
    List<OrderVo> selectAll();

    @Select("select * from orders where uid=#{id}")
    List<Order> selectByUser(Integer id);
}
