<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.xt.entity.User" %>
<%@ page import="com.xt.service.UserService" %>
<%@ page import="com.xt.service.impl.UserServiceImpl" %>
<%@ page import="com.xt.service.UserState" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<c:if test="${user.state le 1}">
    <c:redirect url="index.jsp"/>
</c:if>
<html>
<head>
    <title>Modify User State</title>
</head>
<body>
<%
    UserService service=new UserServiceImpl();
    String op=request.getParameter("op");
    int id=0;
    try{
        id=Integer.parseInt(request.getParameter("id"));
    }
    catch (Exception ex){}
    int ret=-1;
    if("del".equals(op)){
        ret=service.delete(id);
    }
    else if("rec".equals(op)){
        ret=service.recover(id);
    }
    else if(user.getState()== UserState.SUPER_ADMIN
        &&   "deg".equals(op)){
        ret=service.degrade(id);
    }
    else if(user.getState()== UserState.SUPER_ADMIN
            &&  "upg".equals(op)){
        ret=service.upgrade(id);
    }
    if(ret>0){
        request.setAttribute("msg","操作成功");
    }
    else if(ret==-1){
        request.setAttribute("msg","权限不足或无此功能");
    }
    else{
        request.setAttribute("msg","操作失败");
    }
    request.getRequestDispatcher("useradmin.jsp").forward(request,response);
%>
</body>
</html>
