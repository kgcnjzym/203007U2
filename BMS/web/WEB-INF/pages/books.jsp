<%@ page import="java.util.List" %>
<%@ page import="com.xt.entity.Book" %>
<%@ page import="com.xt.service.BookService" %>
<%@ page import="com.xt.service.impl.BookServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
    <%@include file="/WEB-INF/pages/inc.jsp"%>
</head>
<body>
<%@ include file="/WEB-INF/pages/menu.jsp"%>
    <h2 style='color:red'>${msg}</h2>
    <div class="container">
        <div class="row">
            <table align="center" class="table col-xs-12 table-striped" >
                <thead>
                <tr>
                    <th>图书名称</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>出版日期</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td><a href="book?op=one&bid=${book.id}">${book.name}</a></td>
                        <td>${book.author}</td>
                        <td>${book.pubComp}</td>
                        <td>${book.pubDate}</td>
                        <td>
                            <button class="btn btn-xs btn-primary glyphicon glyphicon-book" type="button"
                                ${book.count gt 0?"":"disabled"}
                                    onclick="location='borrow.do?op=borrow&bid=${book.id}'">借阅
                            </button>
                            <button class="btn btn-xs btn-danger glyphicon glyphicon-shopping-cart"
                                    type="button" ${book.count gt 0?"":"disabled"}
                                    onclick="location='cart.do?op=add&bid=${book.id}'">购买</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
    </div>
</body>
</html>
