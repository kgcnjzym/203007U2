<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>图书管理</title>
    <%@include file="/WEB-INF/pages/inc.jsp"%>
</head>
<body>
<%@ include file="/WEB-INF/pages/menu.jsp"%>
<h3 style="color:red">${msg}</h3>
<div class="container">
    <div class="row">
        <table align="center" class="table col-xs-12 table-striped" >
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>PubDate</th>
        <th>Price</th>
        <th>Cover</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="b" items="${books}">
        <tr>
            <td>${b.id}</td>
            <td>${b.name}</td>
            <td>${b.author}</td>
            <td>${b.pubComp}</td>
            <td><fmt:formatDate value="${b.pubDate}" pattern="yyyy-MM"/> </td>
            <td>${b.price}</td>
            <td>
                <form action="bookadmin.do?op=cover" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="bid" value="${b.id}">
                    <input type="file" name="cover" accept="image/gif,image/jpeg,image/png" >
                    <button>修改封面</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    </div>
</div>
<hr>
<form action="bookadmin.do">
    <input type="hidden" name="op" value="add">
    <div class="container">
        <div class="row">
            <div class="col-xs-6 col-xs-offset-3 col-sm-4 col-sm-offset-4">
                <input placeholder="Book Title" type="text" name="name" class="form-control">
                <input placeholder="Book Author" type="text" name="author" class="form-control">
                <input placeholder="Publisher" type="text" name="publisher" class="form-control">
                <input placeholder="Pub Date" type="text" name="pubdate" class="form-control">
                <input placeholder="Book Count" type="text" name="count" class="form-control">
                <input placeholder="Book Price" type="text" name="price" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-6 col-xs-offset-3 col-sm-4 col-sm-offset-4 text-center">
                <button class="btn btn-sm btn-primary">Add Book</button>
                <button type="reset" class="btn btn-sm btn-danger">Reset</button>
            </div>
        </div>
    </div>
</form>
</body>
</html>
