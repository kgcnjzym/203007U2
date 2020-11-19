package com.xt.service;

import com.xt.entity.Paginate;
import com.xt.entity.User;

import java.util.List;

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
    int modifyPass(String newPass, String oldPass, Integer uid);

    /**
     *
     * @param user
     * @return
     */
    int modifyInfo(User user);

    /**
     * 分页查找用户信息
     * @param page
     * @return
     */
    List<User> getByPage(Paginate page);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 恢复
     * @param id
     * @return
     */
    int recover(Integer id);

    /**
     * 降级
     * @param id
     * @return
     */
    int degrade(Integer id);

    /**
     *  升级
     * @param id
     * @return
     */
    int upgrade(Integer id);
}
