package com.xt.service;

import com.xt.entity.User;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/29 09:58
 * @since V1.00
 */
public interface UserService {
    int reg(User user);

    User getById(Integer id);
}
