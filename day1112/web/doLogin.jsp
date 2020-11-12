<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.xt.entity.User" %>
<%@ page import="com.xt.service.UserService" %>
<%@ page import="com.xt.service.impl.UserServiceImpl" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user=new User();
    user.setName(request.getParameter("name"));
    user.setPassword(request.getParameter("pass"));
    UserService service=new UserServiceImpl();
    try{
        User temp=service.login(user);
        if(temp==null){
            request.setAttribute("msg","登陆失败！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else{
            session.setAttribute("user",temp);
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
