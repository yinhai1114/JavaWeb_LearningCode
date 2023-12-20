<%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/20 Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<h1>jsp声明脚本</h1>
<body>
<%!
    //这里我们可以声明该jsp需要使用的属性，方法，静态代码块, 内部类
    //也就是给 statement.jsp 对应的 statement_jsp 类定义成员
    //1. 属性
    private String name = "jack";
    private int age;
    private static String company;

    //2 方法
    public String getName() {
        return name;
    }
    //3. 静态代码块
    static {
        company = "字节跳动";
    }
%>
</body>
</html>
