<%@ page import="java.util.List" %>
<%@ page import="com.xt.entity.Book" %>
<%@ page import="com.xt.service.BookService" %>
<%@ page import="com.xt.service.impl.BookServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<html>
<head>
    <title>Book</title>
</head>
<body>
<%@ include file="/WEB-INF/pages/menu.jsp"%>
<%
    String msg=(String)request.getAttribute("msg");
    if(msg!=null){
        out.print("<h2 style='color:red'>"+msg+"</h2>");
    }
%>
    <table border="1" align="center" width="600">
        <thead>
        <tr>
            <th>图书封面</th>
            <th>图书名称</th>
            <th>作者</th>
            <th>出版社</th>
            <th>出版日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            BookService bookService = new BookServiceImpl();
            List<Book> ret = bookService.getAll();
            for (int i = 0; i < ret.size(); i++) {
                Book book=ret.get(i);
                out.print("<tr>");
                out.print("<td><img src='imgs/book/" + book.getId() + ".jpg' width='80'></td>");
                out.print("<td>" + book.getName() + "</td>");
                out.print("<td>" + book.getAuthor() + "</td>");
                out.print("<td>" + book.getPubComp() + "</td>");
                out.print("<td>" + book.getPubDate() + "</td>");
        %>
        <td>
            <button type="button" <%=book.getCount()>0?"":"disabled"%>
                    onclick="location='borrow.jsp?bid=<%=book.getId()%>'">借阅</button>
            <button type="button" <%=book.getCount()>0?"":"disabled"%>
                    onclick="location='addCart.jsp?op=add&bid=<%=book.getId()%>'">购买</button>
        </td>
        <%}%>
        </tbody>
    </table>
</body>
</html>
