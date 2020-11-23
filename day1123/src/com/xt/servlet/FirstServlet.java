package com.xt.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/23 09:15
 * @since V1.00
 */
public class FirstServlet extends HttpServlet {
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("first destroy...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String name=config.getInitParameter("test");
        System.out.println("first init...:test="+name);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //有就获取，没有就创建
        HttpSession session=req.getSession();
        //应用程序：
        ServletContext context=getServletContext();
        if(session.getAttribute("name")==null){
            session.setAttribute("name","session");
            System.out.println("store in session");
        }
        if(context.getAttribute("name")==null){
            context.setAttribute("name","application");
            System.out.println("store in application");
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>First Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>this is First Servlet</h1>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
