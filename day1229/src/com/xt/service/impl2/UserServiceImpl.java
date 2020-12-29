package com.xt.service.impl2;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/29 09:58
 * @since V1.00
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao dao;
    @Override
    @Transactional
    public int reg(User user) {
        int ret=0;
        dao.update(173);
        ret=dao.insert(user);
        return ret;
    }

    @Override
    public User getById(Integer id) {
        return dao.selectById(id);
    }


}
