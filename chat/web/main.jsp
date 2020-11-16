<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/pages/check.jsp"%>
<html>
  <head>
    <title>Main</title>
  </head>

  <frameset rows="*,100">
    <frameset cols="*,180">
      <frame src="msg.jsp">
      <frame src="list.jsp">
    </frameset>
    <frame src="send.jsp">
    </frameset>
  </frameset>

</html>
