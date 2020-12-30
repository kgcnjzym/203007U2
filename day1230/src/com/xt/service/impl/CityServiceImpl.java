package com.xt.service.impl;

import com.xt.dao.CityDao;
import com.xt.entity.City;
import com.xt.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/30 10:35
 * @since V1.00
 */
@Service
public class CityServiceImpl implements CityService {
    @Resource
    private CityDao dao;
    @Override
    public City getById(Integer id) {
        return dao.selectById(id);
    }
}
