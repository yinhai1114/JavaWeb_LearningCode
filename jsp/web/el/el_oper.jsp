<%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/20 Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el的运算符</title>
</head>
<body>
<h1>el的运算符</h1>
<%
    request.setAttribute("num1", 90);
    request.setAttribute("num2", 30);
%>
num1+num2=${num1 + num2}<br/>
num1>num2=${num1 > num2}<br/>
</body>
</html>

