<%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/20 Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表达式脚本的使用</title>
</head>
<body>
<h1>个人信息</h1>
<%
    String name = "yinhai";
    String email = request.getParameter("email");
%>
用户名: <%=name%><br/>
工作是: <%="java工程师"%><br/>
年龄: <%=request.getParameter("age")%><br/>
电邮: <%=email%>
</body>
</html>
