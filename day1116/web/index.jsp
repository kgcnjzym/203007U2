<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <jsp:useBean id="user" class="com.xt.entity.User" />
<%--  <jsp:setProperty name="user" property="name" value="tom"/>--%>
<%--  <jsp:setProperty name="user" property="email" param="mail"/>--%>
<%--  <jsp:setProperty name="user" property="age" />--%>
  <jsp:setProperty name="user" property="*" />
<%--
User user=(User)pageContext.getAttribute("user");
if(user==null){
  user=new User();
  pageContext.setAttribute("user",user);
}
--%>
<h1><%=user.getName()%></h1>
  <h1>getProperty:<jsp:getProperty name="user" property="name"/></h1>
  <h1><%=pageContext.getAttribute("user")%></h1>
  </body>
</html>
