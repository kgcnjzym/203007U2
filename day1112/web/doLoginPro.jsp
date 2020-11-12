<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.xt.entity.User" %>
<%@ page import="com.xt.service.UserService" %>
<%@ page import="com.xt.service.impl.UserServiceImpl" %>
<html>
<head>
    <title>Login With Cookie</title>
</head>
<body>
<%
    User user=new User();
    String pass=request.getParameter("pass");
    user.setName(request.getParameter("name"));
    user.setPassword(pass);
    UserService service=new UserServiceImpl();
    try{
        User temp=service.login(user);
        if(temp==null){
            request.setAttribute("msg","登陆失败！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else{
            session.setAttribute("user",temp);
            //还有存储到cookie中
            int st=0;
            try{
                st=Integer.parseInt(request.getParameter("savetime"));
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
            response.addCookie(ck);
            ck=new Cookie("pass",pass);
            ck.setMaxAge(st);
            response.addCookie(ck);
            response.sendRedirect("main.jsp");
        }
    }
    catch (Exception ex){
        request.setAttribute("msg","登陆异常："+ex.getMessage());
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
%>
</body>
</html>
