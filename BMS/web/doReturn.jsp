<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.xt.service.BorrowService" %>
<%@ page import="com.xt.service.impl.BorrowServiceImpl" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<html>
<head>
    <title>Return Book</title>
</head>
<body>
<%
    BorrowService service=new BorrowServiceImpl();
    String ref="returnbooks.jsp";
    if(user.getState()>1){//管理员
        ref="adminreturnbooks.jsp";
    }
    int bid=0;
    int uid;
    try{
        bid=Integer.parseInt(request.getParameter("bid"));
        if(user.getState()>1){//管理员
            uid=Integer.parseInt(request.getParameter("uid"));
        }
        else{
            uid=user.getId();
        }
        int rt=service.returnBook(uid,bid);
        if(rt>0){
            request.setAttribute("msg","图书归还成功！");
        }
        else{
            request.setAttribute("msg","图书归还失败！");
        }
    }
    catch (NumberFormatException ex){
        request.setAttribute("msg","图书编号或用户编号不合法！");
    }
    catch (RuntimeException rex){
        request.setAttribute("msg",rex.getMessage());
    }
    request.getRequestDispatcher(ref).forward(request,response);
%>
</body>
</html>
