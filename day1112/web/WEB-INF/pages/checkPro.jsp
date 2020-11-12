<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.xt.entity.User" %>
<%@ page import="com.xt.service.UserService" %>
<%@ page import="com.xt.service.impl.UserServiceImpl" %>
<%--会话+Cookie访问控制--%>
<%
    User user=(User)session.getAttribute("user");
    if(user==null){
        //会话中读取不到，再从cookie中读取
        Cookie []cks=request.getCookies();
        String name=null;
        String pass=null;
        for (int i=0;cks!=null && i<cks.length;i++){
            Cookie ck=cks[i];
            if("name".equals(ck.getName())){
                name=ck.getValue();
            }
            else if("pass".equals(ck.getName())){
                pass=ck.getValue();
            }
        }
        if(name==null || pass==null) {
            response.sendRedirect("login.jsp");
            return;
        }
        user=new User();
        user.setName(name);
        user.setPassword(pass);
        UserService service=new UserServiceImpl();
        try {
            User temp = service.login(user);
            if(temp!=null){
                session.setAttribute("user",temp);
            }
        }
        catch(Exception ex){
            response.sendRedirect("login.jsp");
            return;
        }

    }
%>