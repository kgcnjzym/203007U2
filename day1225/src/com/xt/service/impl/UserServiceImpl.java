package com.xt.service.impl;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.mb.SqlSession;
import com.xt.service.UserService;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 11:14
 * @since V1.00
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(Integer id) {
        System.out.println("在impl实现类中执行getUser操作");
        return null;
    }

    private UserDao dao= SqlSession.getDao(UserDao.class);
    @Override
    public int insert(User user) {
        dao.update(user.getId());
        User temp=dao.selectByName(user.getName());
        if(temp!=null){
            throw new RuntimeException("用户名【"+user.getName()+"】已存在");
        }
        int ret=dao.insert(user.getName(),user.getEmail(),user.getPhone());
        return ret;
    }
}
