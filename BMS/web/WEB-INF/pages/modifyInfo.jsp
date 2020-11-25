
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<%@ include file="/WEB-INF/pages/menu.jsp"%>
<%
    String msg=(String)request.getAttribute("msg");
    if(msg!=null){
        out.print("<h2 style='color:red'>"+msg+"</h2>");
    }
%>
<form action="modify.do" method="post">
    <input type="hidden" name="op" value="info">
    <input type="hidden" name="ref" value="modifyInfo.jsp">
    <p>
        <label for="i1">ID</label>
        <input type="number" name="id" value="<%=user.getId()%>" id="i1" disabled>
    </p>
    <p>
        <label for="n1">姓名:</label>
        <input type="text" name="name"value="<%=user.getName()%>"  id="n1">
    </p>
    <p>
        <label for="e1">邮箱:</label>
        <input type="email" name="email" value="<%=user.getEmail()%>"  id="e1">
    </p>
    <p>
        <label>性别:</label>
        <input type="radio" name="gender" id="m1" value="M" <%="M".equals(user.getGender())?"checked":""%> >
        <label for="m1">男</label>
        <input type="radio" name="gender" id="f1" value="F" <%="F".equals(user.getGender())?"checked":""%> >
        <label for="f1">女</label>
    </p>
    <p>
        <label for="a1">年龄:</label>
        <input type="number" name="age" value="<%=user.getAge()%>"id="a1">
    </p>
    <p>
        <label for="p2">电话:</label>
        <input type="tel" name="phone" value="<%=user.getPhone()%>" id="p2">
    </p>
    <p>
        <button>修改</button>
        <button type="reset">清空</button>
    </p>
</form>
</body>
</html>
