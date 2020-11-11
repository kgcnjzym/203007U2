<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求数据获取</title>
</head>
<body>
<form action="doForm.jsp" method="get">
    <p>
        <label for="t1">姓名：</label>
        <input type="text" name="name" id="t1">
    </p>
    <p>
        <label for="t2">密码：</label>
        <input type="password" name="pass" id="t2">
    </p>
    <p>
        <label for="t3">Email：</label>
        <input name="email" id="t3">
    </p>
    <p>
        <label>性别：</label>
        <input type="radio" name="gender" id="rdo1" value="M" checked>
        <label for="rdo1">男</label>
        <input type="radio" name="gender" id="rdo2"value="F">
        <label for="rdo2">女</label>
    </p>
    <p>
        <label>爱好：</label>
        <input type="checkbox" name="hobby" id="chk1" value="电影">
        <label for="chk1">Movie</label>
        <input type="checkbox" name="hobby" id="chk2" value="音乐">
        <label for="chk2">Music</label>
        <input type="checkbox" name="hobby" id="chk3" value="足球">
        <label for="chk3">Soccer</label>
        <input type="checkbox" name="hobby" id="chk4" value="旅游">
        <label for="chk4">Travel</label>
    </p>
    <p>
        <input type="submit" value="提交">
        <input type="submit" formmethod="post" value="POST提交">
        <input type="reset" value="重置">
    </p>

</form>
</body>
</html>
