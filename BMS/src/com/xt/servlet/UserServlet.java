package com.xt.servlet;

import com.xt.entity.User;
import com.xt.service.UserService;
import com.xt.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 杨卫兵
 * @version V1.00
 * @date 2020/11/24 11:54
 * @since V1.00
 */
public class UserServlet extends HttpServlet {
    private UserService service=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user")!=null){
            req.getRequestDispatcher("book?op=index").forward(req,resp);
            return;
        }
        String op=req.getParameter("op");
        if("showreg".equals(op)){
            req.getRequestDispatcher("/WEB-INF/pages/reg.jsp").forward(req,resp);
        }
        else if("login".equals(op)){
            doLogin(req,resp);
        }
        else if("reg".equals(op)){
            doReg(req,resp);
        }
        else{
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
        }
    }

    private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session=req.getSession();
        String seCode=(String)session.getAttribute("code");
        String code=req.getParameter("code");
        if(seCode==null || !seCode.equalsIgnoreCase(code)){
            req.setAttribute("msg","验证码不正确");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
            return;
        }
        User user=new User();
        String name=req.getParameter("name");
        String pass=req.getParameter("pass");
        if(name==null || name.trim().equals("") || pass ==null ||pass.trim().equals("")){
            req.setAttribute("msg","登陆信息不完整");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
            return;
        }
        user.setName(name.trim());
        user.setPassword(pass.trim());
        UserService service=new UserServiceImpl();
        try{
            User temp=service.login(user);
            if(temp==null){
                req.setAttribute("msg","登陆失败！");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
            else{
                session.setAttribute("user",temp);
                //还有存储到cookie中
                int st=0;
                try{
                    st=Integer.parseInt(req.getParameter("savetime"));
                    if(st==-1){
                        st=Integer.MAX_VALUE;
                    }
                    else {
                        st=st*24*60*60;
                    }
                }
                catch (Exception ex){}
                Cookie ck=new Cookie("name",temp.getName());
                ck.setMaxAge(st);
                resp.addCookie(ck);
                ck=new Cookie("pass",pass);
                ck.setMaxAge(st);
                resp.addCookie(ck);
                resp.sendRedirect("book?op=index");
            }
        }
        catch (Exception ex){
            req.setAttribute("msg","登陆异常："+ex.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    private void doReg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String gender=req.getParameter("gender");
        String phone=req.getParameter("phone");
        String pass=req.getParameter("pass");
        String repass=req.getParameter("repass");

        try{

            if(name==null || ! name.matches(".+")){
                throw new RuntimeException("姓名不合要求");
            }
            if(pass==null || !pass.equals(repass)){
                throw new RuntimeException("密码不合要求");
            }
            if(email==null || ! email.matches("\\w+@\\w+\\.\\w+")){
                throw new RuntimeException("Email不合要求");
            }
            if(gender==null || ! gender.matches("M|F")){
                throw new RuntimeException("性别不合要求");
            }
            if(phone==null || ! phone.matches("1\\d{10}")){
                throw new RuntimeException("电话号码不合要求");
            }
            User temp=new User();
            temp.setAge(Integer.parseInt(req.getParameter("age")));
            temp.setName(name);
            temp.setEmail(email);
            temp.setGender(gender);
            temp.setPhone(phone);
            temp.setPassword(pass);
            try {
                int ret = service.reg(temp);
                if(ret>0){
                    req.setAttribute("msg","用户注册成功");
                    req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
                    return;
                }
                else{
                    req.setAttribute("msg","用户注册失败");
                }
            }
            catch (Exception ex){
                req.setAttribute("msg",ex.getMessage());
            }
        }
        catch (NumberFormatException ex){
            req.setAttribute("msg","年龄不符合要求");
        }
        catch (RuntimeException rex){
            req.setAttribute("msg",rex.getMessage());
        }
        req.getRequestDispatcher("/WEB-INF/pages/reg.jsp").forward(req,resp);
    }
}
