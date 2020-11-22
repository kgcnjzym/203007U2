<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bf" uri="http://www.xt.com/203007/bms/functions" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<html>
<head>
    <title>购物车</title>
    <style>
        table{
            width: 800px;
            margin: 0 auto;
        }
        .btn{
            width: 14px;
            height: 14px;
            font-size: 12px;
            line-height: 14px;
            text-align: center;
            border: 1px outset darkgray;
            background: lightgray;
            outline: none;
        }
    </style>
    <script>
        function deleteSelected() {
            let bids=document.getElementsByName("bid");
            let ids=[];
            for(let i=0;i<bids.length;i++){
                if(bids[i].checked){
                    ids.push(bids[i].value);
                }
            }
            if(ids.length==0){
                alert('请先选中要批量删除的图书');
                return;
            }
            let url="addCart.jsp?op=dels";
            for(let i=0;i<ids.length;i++){
                url+="&bid="+ids[i];
            }
            location=url;
        }
    </script>
</head>
<body>
<%@ include file="/WEB-INF/pages/menu.jsp"%>
<h3 style="color:red">${msg}</h3>
<div class="container" style="background-color: transparent">
<table border="1" >
    <thead>
    <tr>
        <th><button onclick="deleteSelected()">批量删除</button></th>
        <th>图书名称</th>
        <th>购买数量</th>
        <th>单价</th>
        <th>小计</th>
    </tr>
    </thead>
    <tbody>
        <c:if test="${empty carts}" var="rt">
            <tr><td colspan="5">暂无选购图书</td></tr>
        </c:if>
        <c:if test="${not rt}">
            <c:set var="sum" value="0"/>
            <c:forEach var="en" items="${carts}">
                <c:set var="book" value="${bf:getBook(en.value.id)}"/>
                <c:set var="sum" value="${en.value.count*book.price+sum}"/>
                <tr>
                    <td><input type="checkbox" name="bid" value="${en.key}"></td>
                    <td>${book.name}</td>
                    <td>
                        <button class="btn"
                                onclick="location='addCart.jsp?op=sub&bid=${en.key}'">-</button>
                            ${en.value.count}
                        <button class="btn"
                onclick="location='addCart.jsp?op=add&bid=${en.key}'">+</button>
                        <button class="btn" onclick="location='addCart.jsp?op=del&bid=${en.key}'">x</button>
                    </td>
                    <td><fmt:formatNumber value="${book.price}" type="currency"
                                          currencySymbol="￥" /> </td>
                    <td><fmt:formatNumber value="${en.value.count*book.price}" type="currency"
                                          currencySymbol="￥" /></td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="3">合计：</td>
        <td colspan="2"><fmt:formatNumber value="${sum}" type="currency"
                                          currencySymbol="￥" /></td>
    </tr>
    </tfoot>
</table>
<h3><a href="order.jsp">结算</a>
    <a href="addCart.jsp?op=clear">清空购物车</a></h3>
</div>
</body>
</html>
