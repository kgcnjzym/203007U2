<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/check.jsp"%>
<html>
  <head>
    <title>list</title>
    <script>
      onload=function(){
        setTimeout(function(){
          location.reload();
        },3000)
      }
    </script>
  </head>
  <body>

  <%
    List<String> names=(List<String>)application.getAttribute("users");
    for(int i=0;i<names.size();i++){
      String name=names.get(i);
      out.print("<p>"+name);
      if(user.equals(name)){
        out.print("<a href='logoff.jsp' target='_top'>退出</a>");
      }
      out.print("</p>");
    }
  %>
  </body>
</html>
