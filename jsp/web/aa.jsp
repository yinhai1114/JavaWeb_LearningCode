<%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/20 Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>aa.jsp</title>
</head>
<body>
<h1>aa.jsp</h1>
<%--
1. jsp提供了很多标签，但是因为jsp不是重点，老韩就讲一个常用forward
2. jsp:forward 本质就是 等价 request.getRequestDispatcher("/bb.jsp").for...
--%>
<jsp:forward page="/bb.jsp"></jsp:forward>
</body>
</html>
