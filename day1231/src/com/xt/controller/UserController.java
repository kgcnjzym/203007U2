package com.xt.controller;

import com.github.pagehelper.PageInfo;
import com.xt.entity.User;
import com.xt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/31 12:04
 * @since V1.00
 */
@Controller
public class UserController {
    @Resource
    private UserService service;
    @RequestMapping("user")
    public ModelAndView getById(Integer id){
        User temp=service.getById(id);
        ModelAndView mav=new ModelAndView("user1");
        mav.addObject("user",temp);
        return mav;
    }
    @RequestMapping("users")
    public ModelAndView getByPage(Integer pno,Integer psize){
        List<User> users=service.getByPage(pno,psize);
        PageInfo<User> info=new PageInfo<>(users);
        ModelAndView mav=new ModelAndView("users");
        mav.addObject("users",info);
        return mav;
    }
}
