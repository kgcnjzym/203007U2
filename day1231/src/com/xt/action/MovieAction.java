package com.xt.action;

import com.xt.mvc.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/12/31 09:19
 * @since V1.00
 */
public class MovieAction implements Action {
    @Override
    public String doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is MovieAction");
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.write("{\"name\":\"SpideMan\",\"price\":40,\"minutes\":180}");
        out.close();
        return null;//"/movie";
    }
}
