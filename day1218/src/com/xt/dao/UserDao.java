package com.xt.dao;

import com.xt.entity.User;
import com.xt.entity.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/18 14:42
 * @since V1.00
 */
public interface UserDao {
    /**
     * 根据图书编号查询用户购买信息
     * @param bid
     * @return
     */
    List<UserVo> selectById(Integer bid);

    /**
     * 根据用户名和/或电子邮件进行模糊查询
     * @param user
     * @return
     */
    List<User> selectByUser(User user);

    /**
     * 根据用户名和/或电子邮件进行模糊查询
     * @param user
     * @return
     */
    List<User> selectByUser2(User user);

    /**
     * 根据用户名和/或电子邮件进行模糊查询
     * @param user
     * @return
     */
    List<User> selectByUser3(User user);

    /**
     * 根据用户名和/或电子邮件进行模糊查询
     * @param user
     * @return
     */
    List<User> selectByUser4(User user);

    /**
     * 根据不同年龄条件查询
     * @param ages
     * @return
     */
    List<User> selectByAges(Map<String,Integer> ages);
    /**
     * 根据不同年龄条件查询
     * @param minAge
     * @param maxAge
     * @return
     */
    List<User> selectByAges2(@Param("minAge") Integer minAge,
                             @Param("maxAge") Integer maxAge);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int update2(User user);

    /**
     * 批量修改用户状态
     * @param ids
     * @param newState
     * @param oldState
     * @return
     */
    int updateStates(@Param("ids") List<Integer> ids,
                     @Param("newState") Integer newState,
                     @Param("oldState") Integer oldState);

    /**
     * 批量增加用户
     * @param user
     * @return
     */
    int insertUsers(List<User> user);
}
