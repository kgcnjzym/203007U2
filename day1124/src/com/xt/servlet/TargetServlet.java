package com.xt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/24 09:44
 * @since V1.00
 */
public class TargetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getClass());
        String name=req.getParameter("name");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("<title>target</title>");
        out.write("</head>");
        out.write("<body>");
        out.write("<h1>"+name+"</h1>");
        out.write("</body>");
        out.write("</html>");
        out.close();
    }
}
