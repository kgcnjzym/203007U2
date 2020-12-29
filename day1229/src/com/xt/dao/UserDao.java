package com.xt.dao;

import com.xt.entity.User;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/29 09:54
 * @since V1.00
 */
public interface UserDao {
    int insert(User user);
    User selectById(Integer id);
    int update(Integer id);
}
