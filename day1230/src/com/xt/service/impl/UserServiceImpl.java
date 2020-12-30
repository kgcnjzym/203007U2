package com.xt.service.impl;

import com.github.pagehelper.PageHelper;
import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/30 09:49
 * @since V1.00
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao dao;
    @Override
    @Transactional(rollbackFor =Exception.class )
    public int reg(User user) {
        dao.update(user);
        return dao.insert(user);
    }

    @Override
    public User getById(Integer id) {
        return dao.selectById(id);
    }

    @Override
    public List<User> getByPage(int pno, int psize) {
        PageHelper.startPage(pno,psize);
        return dao.selectUsers();
    }

    @Override
    public int modify(User user) {
        return 0;
    }
}
