<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--纯会话访问控制--%>
<%
    String user=(String)session.getAttribute("name");
    if(user==null){
        response.sendRedirect("index.jsp");
        return;
    }
%>