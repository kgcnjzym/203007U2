<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        .error{color:red}
    </style>
</head>
<body>
<%@ include file="/WEB-INF/pages/menu.jsp"%>
<%
    String msg=(String)request.getAttribute("msg");
    if(msg!=null){
        out.print("<h2 class='error'>"+msg+"</h2>");
    }
%>
<form action="doLogin.jsp">
    <p>
        <label>Name:</label>
        <input type="text" name="name">
    </p>
    <p>
        <label>Pass:</label>
        <input type="text" name="pass">
    </p>
    <p>
        <label>Save:</label>
        <select name="savetime">
            <option value="0">不保存</option>
            <option value="1">保存1天</option>
            <option value="7">保存1周</option>
            <option value="31">保存1月</option>
            <option value="-1">永久保存</option>
        </select>
    </p>
    <p>
        <button>Login</button>
        <button type="reset">Reset</button>
    </p>

</form>
</body>
</html>
