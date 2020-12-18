package com.xt.dao;

import com.xt.entity.vo.UserVo;

import java.util.List;

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
}
