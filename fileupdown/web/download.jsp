<%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/26 Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件下载</title>
    <base href="<%=request.getContextPath()+"/"%>>">
</head>
<body>
<h1>文件下载</h1>
<a href="fileDownload?name=Miku.jpg">点击下载Miku.jpg</a><br/><br/>
<a href="fileDownload?name=Rem.png">点击下载 Rem.png</a><br/><br/>
<%--<a href="fileDownload?name=高山流水.mp3">点击下载 高山流水.mp3</a><br/><br/>--%>
</body>
</html>

