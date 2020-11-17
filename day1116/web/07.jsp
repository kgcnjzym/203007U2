<%@ page contentType="text/html;charset=UTF-8"
         language="java"%>
<html>
<head>
    <title>EL简单示例</title>
    <style >
        body{font-size: 24px;}
    </style>
</head>
<body>
${'${'}true && true}  &nbsp;&nbsp; ${true && true}<br>
\${true && true}  &nbsp;&nbsp; ${true && true}<br>
${'${'}true and true}  &nbsp;&nbsp; ${true and true}<br>
${'${'}true || false}  &nbsp;&nbsp; ${true || false}<br>
${'${'}true or false}  &nbsp;&nbsp; ${true or false}<br>
${'${'}not true}  &nbsp;&nbsp; ${not true}<br>
${'${'}! true}  &nbsp;&nbsp; ${!true}<br>
</body>
</html>
