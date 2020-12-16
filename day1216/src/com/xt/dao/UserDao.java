package com.xt.dao;

import com.xt.entity.User;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/16 10:35
 * @since V1.00
 */
public interface UserDao {
    /**
     * 查询用户数量
     * @return
     */
    int getCount();

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insert(User user);
}
