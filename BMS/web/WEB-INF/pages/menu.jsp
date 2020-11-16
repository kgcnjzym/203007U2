<%@ page import="com.xt.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%
    User curr=(User)session.getAttribute("user");
%>
    <div class="container">
        <div class="menu">
            <ul>
                <%if(curr!=null){%>
                <li><a href="index.jsp">HOME</a></li>
                <li><a href="books.jsp">图书借阅</a></li>
                <%if(curr.getState().equals(1)){%>
                <li><a href="returnbooks.jsp">图书归还</a></li>
                <%}else{%>
                <li><a href="adminreturnbooks.jsp">图书归还</a></li>
                <%}%>
                <li><a href="modifyPass.jsp">修改密码</a></li>
                <li><a href="modifyInfo.jsp">修改信息</a></li>
                <li><a href="logoff.jsp">安全退出</a></li>
                <%}else{%>
                <li><a href="login.jsp">登陆</a></li>
                <li><a href="reg.jsp">注册</a></li>
                <%}%>
            </ul>
        </div>
    </div>
</body>
</html>
