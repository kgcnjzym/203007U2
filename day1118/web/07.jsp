<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"
   uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>forEach和forTokens示例</title>
</head>
<body>
<c:set var="str">
    tom:tony.andy;mike,jack
</c:set>
<c:forEach var="s" items="${str}">
    <h2>${s}</h2>
</c:forEach>
<hr>
<c:forTokens var="s" items="${str}" delims=",:.;">
    <h2>${s}</h2>
</c:forTokens>

</body>
</html>
