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
 * @date 2020/11/30 10:17
 * @since V1.00
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        if("reg".equals(op)){
            System.out.println("注册……");
            String name=req.getParameter("name");
            String pass=req.getParameter("pass");
            String repass=req.getParameter("repass");
            String gender=req.getParameter("gender");
            if(name!=null && !name.trim().equals("")
            && pass!=null && !pass.trim().equals("")
            && pass.equals(repass) && gender!=null
            && gender.matches("[MF]") ){
                out.print("注册成功");
            }
            else{
                out.print("注册失败");
            }
        }
        else if("checkname".equals(op)){
            String name=req.getParameter("name");
            if(name==null || name.trim().equals("")){
                out.print("用户名不能为空");
            }
            else if(name.equals("admin") || name.equals("mike")){
                out.print("用户名已存在");
            }
            else{
                out.print("用户名可以使用");
            }
        }
        else{
            System.out.println("other……");
        }
        out.close();
    }
}
