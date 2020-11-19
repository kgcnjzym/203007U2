<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
1.创建国际化消息文件：基础名_语言区域代码.properties
2.绑定消息文件
3.使用消息标签展现
--%>
<%--<fmt:setLocale value="en_US"/>--%>
<fmt:setBundle basename="message" var="msg"/>
<html>
<head>
    <title>国际化示例:<fmt:message bundle="${msg}" key="title" /></title>
</head>
<body>
    <button>
        <fmt:message bundle="${msg}" key="submit"/>
    </button>

    <button type="reset">
        <fmt:message bundle="${msg}" key="reset"/>
    </button>

</body>
</html>
