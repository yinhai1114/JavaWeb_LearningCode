<%@ page import="org.apache.jasper.runtime.HttpJspBase" %><%--
  Created by IntelliJ IDEA.
  User: 64301
  Date: 2023/12/20
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp的简单求和计算器</title>
</head>
<body>
<h1>简单计算器</h1>
<%
    //1.在jsp的 % 标签中 可以写java代码
    int i = 10;
    int j = 20;
    int res = i + j;
    //2.jsp内置对象可以直接使用 比如out
    out.println(i + "+" + j + "=" + res);
    HttpJspBase
%>
</body>
</html>
