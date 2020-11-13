<%@ page import="com.xt.service.BorrowService" %>
<%@ page import="com.xt.service.impl.BorrowServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<html>
<head>
    <title>borrow</title>
</head>
<body>
    <%
        try {
            int bid = Integer.parseInt(request.getParameter("bid"));
            BorrowService service=new BorrowServiceImpl();
            int ret=service.lend(user.getId(),bid);
            if(ret>0){
                request.setAttribute("msg","借阅成功");
            }
            else{
                request.setAttribute("msg","借阅失败");
            }
        }
        catch (NumberFormatException ex){
            request.setAttribute("msg","参数不合法");
        }
        catch (RuntimeException rex){
            request.setAttribute("msg",rex.getMessage());
        }
        request.getRequestDispatcher("books.jsp").forward(request,response);
    %>
</body>
</html>
