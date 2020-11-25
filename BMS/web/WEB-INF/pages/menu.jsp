<%@ page import="com.xt.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Menu</title>
    <style>
        *{padding: 0;margin:0;}
        .container{
            width: 100%;
            min-width: 800px;
            background: lightgray;
        }
        .menu{
            width: 800px;
            margin: 0 auto;
            background: lightgray;
        }
        .menu ul{
            list-style: none;
        }
        .menu ul li{
            display: inline;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="menu">
            <ul>
                <c:if test="${not empty user}" var="rt">
                <li><a href="index.jsp">HOME</a></li>
                <li><a href="books.jsp">图书列表</a></li>
                <li><a href="carts.jsp">购物车</a></li>
                <c:if test="${user.state eq 1}">
                <li><a href="returnbooks.jsp">图书归还</a></li>
                </c:if>
                <c:if test="${user.state gt 1}">
                    <li><a href="adminreturnbooks.jsp">图书归还</a></li>
                    <li><a href="addbook.jsp">添加图书</a></li>
                    <li><a href="useradmin.do">用户管理</a></li>
                </c:if>
                <li><a href="modify.do?op=showpass">修改密码</a></li>
                <li><a href="modify.do?op=showinfo">修改信息</a></li>
                <li><a href="myorders.jsp">我的订单</a></li>
                <li><a href="logoff.jsp">安全退出</a></li>
                </c:if>
                <c:if test="${not rt}">
                <li><a href="login.jsp">登陆</a></li>
                <li><a href="reg.jsp">注册</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</body>
</html>
