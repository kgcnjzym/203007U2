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
@WebServlet("/fifth.do")
public class FifthServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String age=req.getParameter("age");
        String email=req.getParameter("email");

        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.write("name="+name+",age="+age+",email="+email);
        out.close();
    }
}
