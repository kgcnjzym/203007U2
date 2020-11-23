package com.xt.servlet;

import com.xt.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责用户注册和登陆
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/23 10:32
 * @since V1.00
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        ServletContext ctx=getServletContext();
        if("reg".equals(op)){
            String name=req.getParameter("name");
            String pass=req.getParameter("pass");
            User user=new User();
            user.setName(name);
            user.setPassword(pass);
            List<User> users=(List<User>)ctx.getAttribute("users");
            if(users==null){
                users=new ArrayList<>();
                ctx.setAttribute("users",users);
            }
            users.add(user);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        else if("login".equals(op)){
            String name=req.getParameter("name");
            String pass=req.getParameter("pass");
            User user=new User();
            user.setName(name);
            user.setPassword(pass);
            List<User> users=(List<User>)ctx.getAttribute("users");
            if(users==null){
                users=new ArrayList<>();
            }
            if(users.contains(user)){
                req.setAttribute("msg","登陆成功");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
            else{
                req.setAttribute("msg","登陆失败");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }

        }
        else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req,resp);
//    }
}
