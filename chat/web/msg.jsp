<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.xt.entity.Message" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/check.jsp"%>
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
    List<Message> msgs=(List<Message>)application.getAttribute("msgs");
    if(msgs==null){
      msgs=new ArrayList<>();
    }
    Integer start=(Integer)session.getAttribute("start");
    for(int i=msgs.size()-1;i>=start;i--){
      Message message=msgs.get(i);
      if(message.getFrom().equals(user)){
          if(message.getTo().equals("")){
            out.print("你对所有人说："+message.getContent()+"<br>");
          }
          else{
            out.print("你对"+ message.getTo()+"说："+message.getContent()+"<br>");
          }
      }
      else{
        if(message.getTo().equals("")){
          out.print(message.getFrom()+"对所有人说："+message.getContent()+"<br>");
        }
        else if(message.getTo().equals(user)){
          out.print(message.getFrom()+"对你说："+message.getContent()+"<br>");
        }
      }
    }
  %>

  </body>
</html>
