<%--@ page contentType="text/html;charset=UTF-8" language="java" --%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList,java.util.LinkedList"%>
<%--JSP语法错误，无法转译为java文件--%>
<%--<%@ page pageEncoding="GBK"%>--%>
<html>
  <head>
    <title>IndexJSP</title>
    <style>
      h1{color:red;}
    </style>
  </head>
  <body>
  <h1>这是第一个JSP页面</h1>
  <h2><%=3+5 %></h2>
  <%
    //Java语法错误则无法编译产生class文件
  int a;
  System.out.print(a);
  %>
  </body>
</html>
