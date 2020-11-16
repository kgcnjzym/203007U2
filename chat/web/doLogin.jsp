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
    if(name==null || name.trim().equals("")){
      response.sendRedirect("index.jsp");
      return;
    }
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
    List<String> msgs=(List<String>)application.getAttribute("msgs");
    if(msgs==null){
      session.setAttribute("start",0);
    }
    else{
      session.setAttribute("start",msgs.size());
    }
    response.sendRedirect("main.jsp");
  %>
  </body>
</html>
