<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>message</title>
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
    List<String> msgs=(List<String>)application.getAttribute("msgs");
    if(msgs==null){
      msgs=new ArrayList<>();
    }
    for(int i=0;i<msgs.size();i++){
      out.print(msgs.get(i));
    }
  %>

  </body>
</html>
