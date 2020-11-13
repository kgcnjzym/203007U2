<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    String curr=(String)session.getAttribute("name");
    List<String> names=(List<String>)application.getAttribute("users");
    for(int i=0;i<names.size();i++){
      String name=names.get(i);
      out.print("<p>"+name);
      if(curr.equals(name)){
        out.print("<a href='logoff.jsp' target='_top'>退出</a>");
      }
      out.print("</p>");
    }
  %>
  </body>
</html>
