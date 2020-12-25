package com.xt.dao;

import com.xt.entity.User;
import com.xt.mb.Insert;
import com.xt.mb.Select;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 09:37
 * @since V1.00
 */
public interface UserDao {
    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @Select("select * from users where id=?")
    User selectById(Integer id);

    /**
     *
     * @param size
     * @return
     */
    @Select("select * from users limit ?,?")
    List<User> selectPage(Integer start,Integer size);

    /**
     *
     * @param name
     * @param email
     * @param phone
     * @return
     */
    @Insert("insert into users(name,email,phone) values(?,?,?)")
    int insert(String name,String email,String phone);
}
