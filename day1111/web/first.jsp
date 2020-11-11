<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小脚本和声明</title>
</head>
<body>
    <%
        int a;
        a=10;
        int []arr=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=(int)(Math.pow(2,i));
        }
    %>
<%!
    int a;
    int []brr=new int[10];
    {
        for (int i = 0; i < 10; i++) {
            brr[i] = (int) (Math.pow(2, i));
        }
    }
    void test(){}
    int test(int a){return a+1;}
%>
    <%=test(1)%>
<%--    <%=test()%>--%>
    <h1>a in local=<%=a++%></h1>
    <h1>a in class=<%=this.a++%></h1>
    <h3>
        <%=Arrays.toString(arr)%>
    </h3>
    <h3>
        <%=Arrays.toString(brr)%>
    </h3>
</body>
</html>
