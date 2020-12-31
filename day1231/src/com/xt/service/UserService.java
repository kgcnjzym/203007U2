package com.xt.service;

import com.xt.entity.User;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/30 09:48
 * @since V1.00
 */
public interface UserService {
    int reg(User user);

    User getById(Integer id);

    List<User> getByPage(int pno, int psize);

    int modify(User user);
}
