<%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/20 Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c:set标签的使用</title>
</head>
<body>
<h1>c:set标签的使用</h1>
<%--
    <c:set /> set 标签可以往域中保存数据
    1. 等价 域对象.setAttribute(key,value);
    2. scope 属性设置保存到哪个域
            page 表示 PageContext 域（默认值）
            request 表示 Request 域
            session 表示 Session 域
            application 表示 ServletContext 域
    3. var 属性设置 key 是什么
    4. value 属性设置值
--%>
<%--<%--%>
<%--    //Java代码--%>
<%--    request.setAttribute("email", "hsp@sohu.com");--%>
<%--%>--%>
<c:set scope="request" var="name" value="hello JSTL~"></c:set>
c:set-name的值${requestScope.name}
</body>
</html>

