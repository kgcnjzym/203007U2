package com.xt.dao.impl;

import com.xt.dao.BorrowDao;
import com.xt.entity.Borrow;
import com.xt.util.jdbc.JdbcTemplate;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/13 10:42
 * @since V1.00
 */
public class BorrowDaoImpl implements BorrowDao {
    private JdbcTemplate template=new JdbcTemplate();
    @Override
    public int insert(Borrow borrow) {
        String sql="insert into borrow values(?,?,now(),adddate(now(),30),null)";
        return template.update(sql,false,borrow.getRid(),borrow.getBid());
    }
}
