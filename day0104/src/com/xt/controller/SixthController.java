package com.xt.controller;

import com.xt.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/6 09:49
 * @since V1.00
 */
@RestController
@RequestMapping("sixth")
public class SixthController {
    @RequestMapping(path = "t1/{id}",method = RequestMethod.GET)
    public User test1(@PathVariable Integer id){
        User user=new User();
        user.setId(id);
        user.setBirth(new Date());
        return user;
    }

    @RequestMapping(path = "t1/{id}/{name}",method = RequestMethod.GET)
    public User test1(@PathVariable Integer id,
                      @PathVariable String name){
        User user=new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    @RequestMapping(path = "t2/{pno}/{psize}",method = RequestMethod.GET)
    public List<User> test2(@PathVariable Integer pno,
                      @PathVariable Integer psize){
        List<User> users=new ArrayList<>();
        User user=new User();
        user.setId(1);
        user.setName("mike");
        users.add(user);
        user=new User();
        user.setId(2);
        user.setName("andy");
        users.add(user);
        user=new User();
        user.setId(3);
        user.setName("李四");
        users.add(user);
        return users;
    }
}
