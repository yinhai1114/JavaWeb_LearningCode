<%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/21 Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有的妖怪</title>
</head>
<body>
<h1>显示所有的妖怪</h1>
<table border="1px" width="400px">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>skill</td>
    </tr>
    <%--    使用c:foreach循环显示即可 显示id > 200--%>
    <c:forEach items="${monsters}" var="monster">
        <c:if test="${monster.id >= 200}">
            <tr>
                <td>${monster.id}</td>
                <td>${monster.name}</td>
                <td>${monster.skill}</td>
            </tr>
        </c:if>
    </c:forEach>

</table>
</body>
</html>
