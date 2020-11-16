package com.xt.dao.impl;

import com.xt.dao.PenaltyDao;
import com.xt.entity.Penalty;
import com.xt.util.jdbc.JdbcTemplate;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/16 10:02
 * @since V1.00
 */
public class PenaltyDaoImpl implements PenaltyDao {
    private JdbcTemplate template=new JdbcTemplate();
    @Override
    public int insert(Penalty penalty) {
        String sql="insert into penalty values(?,?,now(),?,?)";
        return template.update(sql,false,
                penalty.getUserId(),
                penalty.getBookId(),
                penalty.getType(),
                penalty.getAmount());
    }
}
