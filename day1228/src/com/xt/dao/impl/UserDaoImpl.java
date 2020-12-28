package com.xt.dao.impl;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 11:14
 * @since V1.00
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public int insert(User user) {
        return 0;
    }
}
