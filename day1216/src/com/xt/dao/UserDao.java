package com.xt.dao;

import com.xt.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * 查询若干User
     * @param cnt
     * @return
     */
    List<User> selectUsers(Integer cnt);

    /**
     * 查询年龄小于参数的用户
     * @param maxAge 最大年龄
     * @return
     */
    List<User> selectByAge(Integer maxAge);

    /**
     * 查询年龄在指定范围内的用户
     * @param minAge 最小年龄
     * @param maxAge 最大年龄
     * @return
     */
    List<User> selectByAges(@Param("minAge") Integer minAge,
                            @Param("maxAge") Integer maxAge);


    /**
     * 根据用户名模糊查找1:直接传入含有%的字符串,如：%tom%
     * @param name
     * @return
     */
    List<User> selectByName1(String name);

    /**
     * 根据用户名模糊查找2:传入User对象，使用EL读取
     * @param user
     * @return
     */
    List<User> selectByName2(User user);

    /**
     * 根据用户名模糊查找3:使用正则
     * @param name
     * @return
     */
    List<User> selectByName3(String name);

    /**
     * 根据用户名模糊查找4:使用concat
     * @param name
     * @return
     */
    List<User> selectByName4(String name);

    /**
     * 根据用户名模糊查找5:使用bind标签+参数_parameter
     * @param name
     * @return
     */
    List<User> selectByName5(String name);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insert(User user);
}
