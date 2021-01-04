package com.xt.controller;

import com.xt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2021/1/4 11:52
 * @since V1.00
 */
@Controller
@RequestMapping("user")
@SessionAttributes({"user1"})
public class UserController {
    @RequestMapping("login")
    public String login(@ModelAttribute("user1") User user){
        if("admin".equals(user.getName())
        && "123456".equals(user.getPassword())){
            System.out.println("login success!");
            return "user";
        }
        System.out.println("login fail");
        return "login";
    }

    @ModelAttribute("user1")
    private User init(){
        return new User();
    }
}
