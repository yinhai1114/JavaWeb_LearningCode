<%@ page import="com.yinhai.domain.Monster" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 银小海
  Date: 2023/12/20 Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>演示代码脚本</title>
</head>
<body>
<h1>演示代码脚本</h1>
<%
    //创建ArrayList ,放入两个monster对象
    ArrayList<Monster> monsterList = new ArrayList<>();
    monsterList.add(new Monster(1, "牛魔王", "芭蕉扇"));
    monsterList.add(new Monster(2, "蜘蛛精", "吐口水"));
%>
<table bgcolor="#f0f8ff" border="1px" width="300px">
    <tr>
        <th>id</th>
        <th>名字</th>
        <th>技能</th>
    </tr>
    <%
        for (int i = 0; i < monsterList.size(); i++) {
            //先取出monster对象
            Monster monster = monsterList.get(i);
    %>
    <tr>
        <td><%=monster.getId()%></td>
        <td><%=monster.getName()%></td>
        <td><%=monster.getSkill()%></td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
