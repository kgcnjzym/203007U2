<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>logoff</title>
  </head>
  <body>
  <%
    String name=(String)session.getAttribute("name");
    session.removeAttribute("name");
    session.invalidate();
    List<String> names=(List<String>)application.getAttribute("users");
    names.remove(name);
  %>
  <h2>已退出，点击<a href="index.jsp">这里</a>重新登陆</h2>
  </body>
</html>
