package com.xt.dao;

import com.xt.entity.City;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/2 08:39
 * @since V1.00
 */
public interface CityDao {
    /**
     * 根据上级id查找行政区划
     * @param up
     * @return
     */
    List<City> selectByUp(Integer up);

    /**
     * 根据英文名模糊查询
     * @param ename
     * @return
     */
    List<City> selectByEname(String ename);
}
