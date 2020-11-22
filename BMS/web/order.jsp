<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bf" uri="http://www.xt.com/203007/bms/functions" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<c:if test="${empty carts}">
    <c:redirect url="books.jsp"/>
</c:if>
<html>
<head>
    <title>结算</title>
</head>
<body>
<div class="container" style="background-color: transparent">
    <table border="1" width="500">
        <thead>
        <tr>
            <th>图书名称</th>
            <th>购买数量</th>
            <th>单价</th>
            <th>小计</th>
        </tr>
        </thead>
        <tbody>
            <c:set var="sum" value="0"/>
            <c:forEach var="en" items="${carts}">
                <c:set var="book" value="${bf:getBook(en.value.id)}"/>
                <c:set var="sum" value="${en.value.count*book.price+sum}"/>
                <tr>
                    <td>${book.name}</td>
                    <td>${en.value.count}</td>
                    <td><fmt:formatNumber value="${book.price}" type="currency"
                                          currencySymbol="￥" /> </td>
                    <td><fmt:formatNumber value="${en.value.count*book.price}" type="currency"
                                          currencySymbol="￥" /></td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="2">合计：</td>
            <td colspan="2"><fmt:formatNumber value="${sum}" type="currency"
                                              currencySymbol="￥" /></td>
        </tr>
        </tfoot>
    </table>
    <form action="doOrder.jsp">
        <label>Address:</label>
        <input type="text" name="address" required >
        <button>确认购买</button>
    </form>
</div>
</body>
</html>
