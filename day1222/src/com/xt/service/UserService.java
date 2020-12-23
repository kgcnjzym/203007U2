package com.xt.service;

import com.xt.entity.User;

import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/23 09:13
 * @since V1.00
 */
public interface UserService {
    /**
     * 分页查询方法
     * @param pno
     * @param psize
     * @return
     */
    List<User> getByPage(Integer pno,Integer psize);
}
