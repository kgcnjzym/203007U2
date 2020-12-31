package com.xt.controller;

import com.xt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/31 11:04
 * @since V1.00
 */
@Controller
public class SecondController {

    @RequestMapping("/second")
    public String test1(){
        System.out.println("this is test1 in SecondController");
        return "user";
    }

    @RequestMapping("/second2")
    public ModelAndView test2(){
        System.out.println("this is test2 in SecondController");
        ModelAndView mav=new ModelAndView("user");
        mav.addObject("name","mike");
        //req.setAttribute("name","mike");
        return mav;
    }

    @RequestMapping("/second3")
    public ModelAndView test3(String name){
        ModelAndView mav=new ModelAndView("user");
        mav.addObject("name","Welcome:"+name);
        return mav;
    }

    @RequestMapping("/second4")
    public ModelAndView test4(User user){
        ModelAndView mav=new ModelAndView("user1");
        mav.addObject("user",user);
        return mav;
    }

}
