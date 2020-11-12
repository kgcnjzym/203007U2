<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.xt.entity.User" %>
<%--纯会话访问控制--%>
<%
    User user=(User)session.getAttribute("user");
    if(user==null){
        response.sendRedirect("login.jsp");
        return;
    }
%>