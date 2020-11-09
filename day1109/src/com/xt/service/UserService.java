package com.xt.service;

import com.xt.entity.User;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/9 10:37
 * @since V1.00
 */
public interface UserService {
    /**
     *
     * @param user
     * @return
     */
    int reg(User user);

    /**
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     *
     * @param newPass
     * @param oldPass
     * @param uid
     * @return
     */
    int modifyPass(String newPass,String oldPass,Integer uid);

    /**
     *
     * @param user
     * @return
     */
    int modifyInfo(User user);

}
