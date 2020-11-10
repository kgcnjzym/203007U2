<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First</title>
    <style>
        body{
            font-family: "Courier New";
        }
    </style>
</head>
<body>
    <%
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                out.print(j+"*"+i+"="+(i*j)+" ");
                if(i*j<10){
                    out.print("&nbsp;");
                }
            }
            out.println("<br>");
        }


    %>

</body>
</html>
