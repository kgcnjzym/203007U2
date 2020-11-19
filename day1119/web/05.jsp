<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>函数标签示例2</title>
</head>
<body>
<c:set var="s" value="hello world"/>
<h1>\${fn:contains(s,'World')}:${fn:contains(s,'World')}</h1>
<h1>\${fn:containsIgnoreCase(s,'World')}:${fn:containsIgnoreCase(s,'World')}</h1>
<h1>\${fn:substring(s, 6, 9)}:${fn:substring(s, 6, 9)}</h1>
<h1>\${fn:substring(s, 6, -1)}:${fn:substring(s, 6, -1)}</h1>
</body>
</html>
