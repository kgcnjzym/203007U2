<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作用域综合示例</title>
</head>
<body>
<%
    if (pageContext.getAttribute("pageCount")==null) {
        pageContext.setAttribute("pageCount", 0);
    }
    if (session.getAttribute("sessionCount")==null) {
        session.setAttribute("sessionCount",0);
    }
    if (application.getAttribute("appCount")==null) {
        application.setAttribute("appCount",0);
    }

    Integer count = (Integer)pageContext.getAttribute("pageCount");
    pageContext.setAttribute("pageCount", count+1);
    Integer count2 =  (Integer)session.getAttribute("sessionCount");
    session.setAttribute("sessionCount", count2+1);
    Integer count3 =  (Integer)application.getAttribute("appCount");
    application.setAttribute("appCount", count3+1);

%>
<h2>
<b>页面计数= </b>
<%=pageContext.getAttribute("pageCount")%>
<br/><b>会话计数= </b>
<%=session.getAttribute("sessionCount")%>
<br/><b>应用程序计数= </b>
<%=application.getAttribute("appCount")%>
</h2>

</body>
</html>
