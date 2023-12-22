<%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/22 Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>发表对阿凡达电影评论</h1>
过滤词: apple,hello,hi ${errorInfo}
<form method="post" action="<%=request.getContextPath()%>/homework/showTopic.jsp">
    用户: <input type="text" name="username"><br/>
    评论: <textarea rows="10" name="content" cols="20"></textarea><br/>
    <input type="submit" value="发表评论">
</form>
</body>
</html>
