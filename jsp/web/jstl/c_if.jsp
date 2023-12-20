<%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/20 Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c:if标签使用</title>
</head>
<body>
<c:set scope="request" var="num1" value="20"></c:set>
<c:set scope="request" var="num2" value="10"></c:set>
<c:if test="${num1 > num2}">
    <h1>${num1} > ${num2}</h1>
</c:if>
</body>
</html>
