<%@ page import="com.xt.entity.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/check.jsp"%>
<html>
  <head>
    <title>send</title>
  </head>
  <body>
  <%
    String msg=request.getParameter("message");
    String to=request.getParameter("to");
    List<String> names=(List<String>)application.getAttribute("users");
    if(names.contains(to)) {
      if (!(msg == null || msg.trim().equals(""))) {
        msg = msg.replace("<", "&lt;").replace(">", "&gt;");
        List<Message> msgs = (List<Message>) application.getAttribute("msgs");
        if (msgs == null) {
          msgs = new ArrayList<>();
          application.setAttribute("msgs", msgs);
        }
        Message message = new Message();
        message.setFrom(user);
        message.setTo(to);
        message.setContent(msg);
        msgs.add(message);
      }
    }
  %>
  <form>
  <label>消息：</label>
    <select name="to">
      <option value="">所有人</option>
      <%
        for(int i=0;i<names.size();i++){
          if(names.get(i).equals(user)){
            continue;
          }
          out.print("<option value='"+names.get(i)+"'>"+names.get(i)+"</option>");
        }
      %>
    </select>
  <input type="text" name="message">
  <button>Send</button>
  </form>
  </body>
</html>
