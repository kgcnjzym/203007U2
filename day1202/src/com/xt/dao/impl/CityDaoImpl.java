package com.xt.dao.impl;

import com.xt.dao.CityDao;
import com.xt.entity.City;
import com.xt.util.jdbc.JdbcTemplate;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/2 08:40
 * @since V1.00
 */
public class CityDaoImpl implements CityDao {
    private JdbcTemplate template=new JdbcTemplate();
    @Override
    public List<City> selectByUp(Integer up) {
        String sql="select id,name from city where up=?";
        return template.queryList(sql,City.class,up);
    }

    @Override
    public List<City> selectByEname(String ename) {
        String sql="select distinct name from city " +
                "where ename like concat(?,'%') " +
                "limit 5";
        return template.queryList(sql,City.class,ename);

    }
}
