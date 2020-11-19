package com.xt.dao;

import com.xt.entity.User;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/9 10:10
 * @since V1.00
 */
public interface UserDao {
    /**
     *
     * @param user
     * @return
     */
    int insert(User user);

    /**
     *
     * @param user
     * @return
     */
    User selectByUser(User user);

    /**
     *
     * @param name
     * @param uid
     * @return
     */
    int selectByName(String name, Integer uid);

    /**
     *
     * @param email
     * @param uid
     * @return
     */
    int selectByEmail(String email, Integer uid);

    /**
     *
     * @param phone
     * @param uid
     * @return
     */
    int selectByPhone(String phone, Integer uid);

    /**
     *
     * @param newPass
     * @param oldPass
     * @param uid
     * @return
     */
    int updatePassword(String newPass, String oldPass, Integer uid);

    /**
     *
     * @param user
     * @return
     */
    int updateInfo(User user);

    /**
     *
     * @param uid
     * @param score
     * @return
     */
    int updateScore(Integer uid,Integer score);

    /**
     * 获取用户数量
     * @return
     */
    int selectCount();

    /**
     * 分页获取用户信息
     * @param start
     * @param size
     * @return
     */
    List<User> selectByPage(Integer start,Integer size);


    /**
     * 修改用户状态
     * @param id
     * @param newState
     * @param oldState
     * @return
     */
    int updateState(Integer id,Integer newState,Integer oldState);
}
