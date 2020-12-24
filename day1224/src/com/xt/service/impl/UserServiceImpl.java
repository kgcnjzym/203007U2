package com.xt.service.impl;

import com.xt.dao.UserDao;
import com.xt.service.UserService;
import lombok.Setter;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/24 09:15
 * @since V1.00
 */
public class UserServiceImpl implements UserService {
    @Setter
    private UserDao dao;
    @Override
    public int count() {
        return dao.selectCount();
    }
}
