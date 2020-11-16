<%@ page import="com.xt.entity.vo.BorrowVo" %>
<%@ page import="com.xt.service.BorrowService" %>
<%@ page import="com.xt.service.impl.BorrowServiceImpl" %>
<%@ page import="java.util.List" %>
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
            <th>用户姓名</th>
            <th>图书名称</th>
            <th>借阅时间</th>
            <th>应归还时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            BorrowService borrowService = new BorrowServiceImpl();
            List<BorrowVo> ret = borrowService.getAll();
            for (int i = 0; i < ret.size(); i++) {
                BorrowVo borrowVo=ret.get(i);
                out.print("<tr>");
                out.print("<td>" + borrowVo.getUserName() + "</td>");
                out.print("<td>" + borrowVo.getBookName() + "</td>");
                out.print("<td>" + borrowVo.getLendDate() + "</td>");
                out.print("<td>" + borrowVo.getWillDate() + "</td>");
                out.print("<td><button onclick=\"location='doReturn.jsp?uid="+borrowVo.getRid()+"&bid="+borrowVo.getBid()+"'\">归还</button></td>");
            }
        %>
        </tbody>
    </table>
</body>
</html>
