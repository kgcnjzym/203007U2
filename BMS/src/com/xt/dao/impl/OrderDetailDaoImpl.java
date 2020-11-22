package com.xt.dao.impl;

import com.xt.dao.OrderDetailDao;
import com.xt.entity.OrderDetail;
import com.xt.util.jdbc.JdbcTemplate;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/20 09:06
 * @since V1.00
 */
public class OrderDetailDaoImpl implements OrderDetailDao {
    private JdbcTemplate template=new JdbcTemplate();
    @Override
    public int insert(OrderDetail orderDetail) {
        String sql="insert into orderdetail values(0,?,?,?,?)";
        return template.update(sql,true,
                orderDetail.getOid(),
                orderDetail.getBid(),
                orderDetail.getQuantity(),
                orderDetail.getPrice());
    }

    @Override
    public List<OrderDetail> selectByOrder(Integer oid) {
        String sql="select * from orderdetail where oid=?";
        return template.queryList(sql,OrderDetail.class,oid);
    }

    @Override
    public int deleteByOrder(Integer oid) {
        String sql="delete from orderdetail where oid=?";
        return template.update(sql,false,oid);
    }
}
