package com.xt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/30 08:55
 * @since V1.00
 */
@WebServlet("/first.do")
public class FirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String method=req.getMethod();
        String name=req.getParameter("name");
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.write(method+":"+name);
        out.close();
    }
}
