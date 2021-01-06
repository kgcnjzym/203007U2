package com.xt.controller;

import com.xt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/4 11:52
 * @since V1.00
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("login")
    public String login(User user, HttpSession session){
        if("admin".equals(user.getName())
        && "123456".equals(user.getPassword())){
            System.out.println("login success!");
            session.setAttribute("user",user);
            return "user";
        }
        System.out.println("login fail");
        return "login";
    }

}
