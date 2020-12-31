package com.xt.dao;

import com.xt.entity.User;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/30 09:40
 * @since V1.00
 */
public interface UserDao {
    int insert(User user);

    User selectById(Integer id);

    List<User> selectUsers();

    int update(User user);
}
