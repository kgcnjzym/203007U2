<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mf" uri="http://www.xt.com/203007/test/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>自定义函数标签</title>
</head>
<body>
<%--
1.定义tld文件：在WEB-INF下,配置相关属性
2.定义一个公有类
3.在该类中定义若干公有、静态、且有返回值的方法
4.在页面使用taglib引用
5.与函数标签一样使用
--%>
<h1>${mf:sayHi('tom')}</h1>
<h1>${mf:getNames()}</h1>
<c:forEach var="n" items="${mf:getAll()}">
    <h2>${n}</h2>
</c:forEach>
</body>
</html>
