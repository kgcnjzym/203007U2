package com.xt.dao;

import com.xt.entity.User;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/5 10:32
 * @since V1.00
 */
public interface UserDao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 根据用户名和密码查询用户
     * @param user      包含了用户名和密码
     * @return
     */
    User selectUser(User user);
}
