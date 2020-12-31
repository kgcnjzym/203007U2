package com.xt.action;

import com.xt.mvc.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/31 09:19
 * @since V1.00
 */
public class UserAction implements Action {
    @Override
    public String doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is UserAction");
        return "/user";
    }
}
