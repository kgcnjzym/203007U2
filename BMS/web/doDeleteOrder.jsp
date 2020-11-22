<%@ page import="com.xt.entity.Book" %>
<%@ page import="com.xt.service.OrderService" %>
<%@ page import="com.xt.service.impl.OrderServiceImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.xt.entity.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<%
    int oid=0;
    OrderService service=new OrderServiceImpl();
    try{
        oid=Integer.parseInt(request.getParameter("oid"));
        Order order=new Order();
        order.setOid(oid);
        order.setUid(user.getId());
        int ret=service.deleteOrder(order);
        if(ret>0) {
            request.setAttribute("msg", "订单编号【" + ret+"】删除成功");
        }
        else{
            request.setAttribute("msg", "订单编号【" + ret+"】删除失败");
        }
    }
    catch (NumberFormatException ex){
        request.setAttribute("msg","订单编号不合法");
    }
    catch (RuntimeException ex){
        request.setAttribute("msg",ex.getMessage());
    }
    request.getRequestDispatcher("myorders.jsp").forward(request,response);
%>