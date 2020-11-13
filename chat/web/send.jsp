<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>send</title>
  </head>
  <body>
  <%
    String msg=request.getParameter("message");
    String curr=(String)session.getAttribute("name");
    if(!(msg==null || msg.trim().equals(""))){
      msg=msg.replace("<","&lt;").replace(">","&gt;");
      List<String> msgs=(List<String>)application.getAttribute("msgs");
      if(msgs==null){
        msgs=new ArrayList<>();
        application.setAttribute("msgs",msgs);
      }
      msgs.add(curr+"说："+msg+"<br>");
    }
  %>
  <form>
  <label>消息：</label>
  <input type="text" name="message">
  <button>Send</button>
  </form>
  </body>
</html>
