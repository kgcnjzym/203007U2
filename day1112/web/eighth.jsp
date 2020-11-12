<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读取cookie</title>
</head>
<body>
<%
Cookie []cks=request.getCookies();
for (int i=0;cks!=null && i<cks.length;i++){
    out.print("<h1>"+cks[i].getName()+"="+
    cks[i].getValue()+"</h1>");
}
%>
</body>
</html>
