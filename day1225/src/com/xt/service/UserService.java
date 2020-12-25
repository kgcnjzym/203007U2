package com.xt.service;

import com.xt.entity.User;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 11:13
 * @since V1.00
 */
public interface UserService {
    User getUser(Integer id);

    int insert(User user);
}
