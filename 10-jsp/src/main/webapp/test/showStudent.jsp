<%@ page import="com.itutry.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/11
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table {
            border: 1px black solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th {
            border: 1px black solid;
        }
    </style>
</head>
<body>
    <%
        List<Student> studentList = (List<Student>) request.getAttribute("stuList");
    %>
    <h1 align="center">学生信息表</h1>
    <table align="center">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        <% for (Student stu : studentList) { %>
        <tr>
            <td><%=stu.getId()%></td>
            <td><%=stu.getName()%></td>
            <td><%=stu.getAge()%></td>
            <td><%=stu.getPhone()%></td>
            <td>删除 修改</td>
        </tr>
        <% } %>
    </table>
</body>
</html>
