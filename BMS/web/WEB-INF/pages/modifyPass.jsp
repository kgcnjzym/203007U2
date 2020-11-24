
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<%@ include file="/WEB-INF/pages/menu.jsp"%>
<%
    String msg=(String)request.getAttribute("msg");
    if(msg!=null){
        out.print("<h2 style='color:red'>"+msg+"</h2>");
    }
%>
<form action="doModify.jsp" method="post">
    <input type="hidden" name="op" value="pass">
    <input type="hidden" name="ref" value="modifyPass.jsp">
    <p>
        <label for="p1">旧密码:</label>
        <input type="password" name="oldpass" id="p1">
    </p>
    <p>
        <label for="p2">新密码:</label>
        <input type="password" name="newpass1" id="p2">
    </p>
    <p>
        <label for="p3">新密码:</label>
        <input type="password" name="newpass2" id="p3">
    </p>
    <p>
        <button>修改</button>
        <button type="reset">清空</button>
    </p>
</form>
</body>
</html>
