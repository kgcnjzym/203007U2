<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>doLogin</title>
  </head>
  <body>
  <%
    String name=request.getParameter("name");
    List<String> names=(List<String>)application.getAttribute("users");
    if(names==null){
      names=new ArrayList<>();
      application.setAttribute("users",names);
    }
    if(names.contains(name)){
      response.sendRedirect("index.jsp");
      return;
    }
    names.add(name);
    session.setAttribute("name",name);
    response.sendRedirect("main.jsp");
  %>
  </body>
</html>
