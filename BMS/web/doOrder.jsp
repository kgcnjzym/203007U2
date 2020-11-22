<%@ page import="com.xt.entity.Book" %>
<%@ page import="com.xt.service.OrderService" %>
<%@ page import="com.xt.service.impl.OrderServiceImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bf" uri="http://www.xt.com/203007/bms/functions" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<c:if test="${empty carts}">
    <c:redirect url="books.jsp"/>
</c:if>
<%
    String address=request.getParameter("address");
//    user.getId()
    Map<String, Book> carts=(Map<String, Book>)session.getAttribute("carts");
    OrderService service=new OrderServiceImpl();
    try{
        int ret=service.addOrder(user.getId(),
                new ArrayList(carts.values()));
        session.removeAttribute("carts");
        request.setAttribute("msg","添加成功，订单编号："+ret);
    }
    catch (RuntimeException ex){
        request.setAttribute("msg",ex.getMessage());
    }
    request.getRequestDispatcher("index.jsp").forward(request,response);
%>