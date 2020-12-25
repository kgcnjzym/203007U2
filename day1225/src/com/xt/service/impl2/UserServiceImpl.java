package com.xt.service.impl2;

import com.xt.entity.User;
import com.xt.service.UserService;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/25 14:08
 * @since V1.00
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(Integer id) {
        System.out.println("在impl2实现类中执行getUser操作");
        if(id%2==0){
            throw  new RuntimeException();
        }
        return null;
    }

    @Override
    public int insert(User user) {
        System.out.println("在impl2实现类中执行insert操作");
        return 1;
    }
}
