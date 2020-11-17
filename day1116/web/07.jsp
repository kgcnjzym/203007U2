<%@ page contentType="text/html;charset=UTF-8"
         language="java"%>
<html>
<head>
    <title>EL获取数据</title>
    <style >
        body{font-size: 24px;}
    </style>
</head>
<body>
<%
    int b=10;
    pageContext.setAttribute("a",b);
    request.setAttribute("a",100);
    request.setAttribute("b",99);
    request.setAttribute("b-a",88);
%>
<jsp:useBean id="user" class="com.xt.entity.User" />
<jsp:useBean id="stu" class="com.xt.entity.Student" />
<jsp:setProperty name="user" property="name" value="mike"/>
<jsp:setProperty name="stu" property="name" value="andy"/>
<jsp:setProperty name="stu" property="age" value="20"/>
<p>a=${a}</p>
<p>b=${requestScope.b}</p>
<p>b-a=${requestScope['b-a']}</p>
<p>user=${user}</p>
<p>user.name=${user.name}</p>
<p>stu.name=${stu.name}</p>
<p>stu.age=${stu.myAge}</p>
</body>
</html>
