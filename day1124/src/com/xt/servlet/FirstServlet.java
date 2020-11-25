package com.xt.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/25 10:08
 * @since V1.00
 */
@WebServlet(urlPatterns = "/first.do",
        initParams =@WebInitParam(name = "test",value = "first"),
        loadOnStartup = 1)
public class FirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is first servlet");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init:test="+
                config.getInitParameter("test"));
    }
}
