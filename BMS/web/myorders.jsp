<%@ page import="java.util.List" %>
<%@ page import="com.xt.entity.Book" %>
<%@ page import="com.xt.service.BookService" %>
<%@ page import="com.xt.service.impl.BookServiceImpl" %>
<%@ page import="com.xt.service.OrderService" %>
<%@ page import="com.xt.service.impl.OrderServiceImpl" %>
<%@ page import="com.xt.entity.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<html>
<head>
    <title>我的订单</title>
</head>
<body>
<%@ include file="/WEB-INF/pages/menu.jsp"%>
<%
    OrderService service=new OrderServiceImpl();
    List<Order> orders=service.getByUser(user.getId());
    pageContext.setAttribute("orders",orders);
%>
<h3 style="color:red">${msg}</h3>
    <table border="1" align="center" width="600">
        <thead>
        <tr>
            <th>订单编号</th>
            <th>地址</th>
            <th>总价</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <c:if test="${empty orders}" var="rt">
                <tr><td colspan="4">暂无订单</td></tr>
            </c:if>
            <c:if test="${not rt}">
                <c:forEach var="od" items="${orders}">
                    <tr>
                        <td>${od.oid}</td>
                        <td>${od.address}</td>
                        <td>${od.summary}</td>
                        <td>
                            <button onclick="location='doDeleteOrder.jsp?oid=${od.oid}'">退货</button>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>
</body>
</html>
