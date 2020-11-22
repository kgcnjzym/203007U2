package com.xt.dao.impl;

import com.xt.dao.OrderDao;
import com.xt.entity.Order;
import com.xt.util.jdbc.JdbcTemplate;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/20 09:04
 * @since V1.00
 */
public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate template=new JdbcTemplate();
    @Override
    public int insert(Order order) {
        String sql="insert into orders values(0,?,?,?)";
        return template.update(sql,true,order.getUid(),
                order.getAddress(),order.getSummary());
    }

    @Override
    public Order selectByIdUser(Integer oid, Integer uid) {
        String sql="select * from orders where oid=? and uid=?";
        return template.queryOne(sql,Order.class,oid,uid);
    }

    @Override
    public int delete(Integer oid) {
        String sql="delete from orders where oid=?";
        return template.update(sql,false,oid);
    }

    @Override
    public List<Order> selectByUser(Integer uid) {
        String sql="select * from orders where  uid=?";
        return template.queryList(sql,Order.class,uid);
    }
}
