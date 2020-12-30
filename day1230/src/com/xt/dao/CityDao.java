package com.xt.dao;

import com.xt.entity.City;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/30 10:34
 * @since V1.00
 */
public interface CityDao {
    City selectById(Integer id);
}
