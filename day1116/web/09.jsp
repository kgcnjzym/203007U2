<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL运算符</title>
</head>
<body>
<h2>a+b:${param.a}${param.b}</h2>
<h2>a+b:${param.a+param.b}</h2>
<h2>a/b:${param.a div param.b}</h2>
<h2>a%b:${param.a mod param.b}</h2>
<h2>a>b:${param.a gt param.b}</h2>
<h2>a+0>b+0:${param.a+0 gt param.b+0}</h2>
<hr>
<%
    pageContext.setAttribute("s1",null);
    pageContext.setAttribute("s2","");
    pageContext.setAttribute("s3"," ");
%>
<h2>empty s1:${empty s1}</h2><!--true-->
<h2>empty s2:${empty s2}</h2><!--true-->
<h2>empty s3:${empty s3}</h2><!--false-->
<h2>empty s4:${empty s4}</h2><!--true-->
<hr>
<%
    List<String> lst1=null;
    pageContext.setAttribute("lst1",lst1);
    List<String> lst2=new ArrayList<>();
    pageContext.setAttribute("lst2",lst2);
    List<String> lst3=new ArrayList<>();
    lst3.add(null);
    pageContext.setAttribute("lst3",lst3);
%>
<h2>empty lst1:${empty lst1}</h2><!--true-->
<h2>empty lst2:${empty lst2}</h2><!--true-->
<h2>empty lst3:${empty lst3}</h2><!--false-->
<h2>empty lst4:${empty lst4}</h2><!--true-->
<hr >
<%
    int []arr1=null;
    pageContext.setAttribute("arr1",arr1);
    int []arr2={};
    pageContext.setAttribute("arr2",arr2);
    int []arr3={1};
    pageContext.setAttribute("arr3",arr3);
%>
<h2>empty arr1:${empty arr1}</h2><!--true-->
<h2>empty arr2:${empty arr2}</h2><!--false-->
<h2>empty arr3:${empty arr3}</h2><!--false-->
<h2>empty arr4:${empty arr4}</h2><!--true-->
</body>
</html>
