<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.xt.entity.User" %>
<%@ page import="com.xt.service.UserService" %>
<%@ page import="com.xt.service.impl.UserServiceImpl" %>
<%@ include file="/WEB-INF/pages/checkPro.jsp"%>
<html>
<head>
    <title>Modify User Info or Pass</title>
</head>
<body>
<%
    UserService service=new UserServiceImpl();
    String op=request.getParameter("op");
    String ref=request.getParameter("ref");
    if("pass".equals(op)){
        String oldpass=request.getParameter("oldpass");
        String newpass1=request.getParameter("newpass1");
        String newpass2=request.getParameter("newpass2");
        if(newpass1==null || !newpass1.equals(newpass2) ){
            request.setAttribute("msg","二次密码不同");
        }
        else{
            try {
                int ret = service.modifyPass(newpass1, oldpass, user.getId());
                if(ret>0){
                    request.setAttribute("msg","密码修改成功");
                }
                else{
                    request.setAttribute("msg","密码修改失败");
                }
            }
            catch(Exception ex){
                request.setAttribute("msg",ex.getMessage());
            }
        }
    }
    else if("info".equals(op)){
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String phone=request.getParameter("phone");
        int age=0;
        try{
            age=Integer.parseInt(request.getParameter("age"));
            User temp=new User();
            temp.setId(user.getId());
            temp.setName((name==null||name.trim().equals(""))?user.getName():name);
            temp.setEmail((email==null||email.trim().equals(""))?user.getEmail():email);
            temp.setGender((gender==null||gender.trim().equals(""))?user.getGender():gender);
            temp.setPhone((phone==null||phone.trim().equals(""))?user.getPhone():phone);
            temp.setAge(age);
            try {
                int ret = service.modifyInfo(temp);
                if(ret>0){
                    user.setAge(temp.getAge());
                    user.setName(temp.getName());
                    user.setPhone(temp.getPhone());
                    user.setGender(temp.getGender());
                    user.setEmail(temp.getEmail());
                    request.setAttribute("msg","用户信息修改成功");
                }
                else{
                    request.setAttribute("msg","用户信息修改失败");
                }
            }
            catch (Exception ex){
                request.setAttribute("msg",ex.getMessage());
            }
        }
        catch (Exception ex){
            request.setAttribute("msg","年龄不符合要求");
        }
    }
    else{
        request.setAttribute("msg","无此操作");
    }
    request.getRequestDispatcher(ref).forward(request,response);
%>
</body>
</html>
