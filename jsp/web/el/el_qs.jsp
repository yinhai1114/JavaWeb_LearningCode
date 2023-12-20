<%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/20 Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式的快速入门</title>
</head>
<body>
<h1>el表达式的快速入门</h1>
<%
    request.setAttribute("name", "hello EL表达式");
%>
<%--
    1. 如果name是 null, request.getAttribute() 返回的是null字符串
    2. 如果name是 null, ${name}, 返回的""
--%>
<h1>jsp表达式脚本</h1>
名字= <%=request.getAttribute("name") == null ? "": request.getAttribute("name")%><br/>
<h1>el表达式</h1>
名字= ${name}<br/>
</body>
</html>

