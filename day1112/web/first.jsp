<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>first-1</title>
</head>
<body>
    <%
        pageContext.setAttribute("name","mike");
        request.setAttribute("name","tom");
        request.getRequestDispatcher("first-2.jsp").forward(request,response);
//        pageContext.getAttribute("name");
//        pageContext.removeAttribute("name");
    %>
    <h1>name in page:<%=pageContext.getAttribute("name")%></h1>
    <h1>name in request:<%=request.getAttribute("name")%></h1>

<a href="first-2.jsp">goto 2</a>
</body>
</html>
