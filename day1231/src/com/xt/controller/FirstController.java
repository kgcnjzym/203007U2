package com.xt.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/31 10:28
 * @since V1.00
 */
public class FirstController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req,
                                      HttpServletResponse resp) throws Exception {
        System.out.println("this is FirstController");
        ModelAndView mav=new ModelAndView("/WEB-INF/pages/user.jsp");
        return mav;
    }
}
