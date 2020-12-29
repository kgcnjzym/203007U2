package com.xt.service.impl;

import com.xt.dao.UserDao;
import com.xt.entity.User;
import com.xt.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/28 11:13
 * @since V1.00
 */
@Service
public class UserServiceImpl implements UserService {
    //@Autowired
    //@Qualifier
    @Resource
    private UserDao dao;
    @Override
    public int reg(User user) {
        return dao.insert(user);
    }
}
