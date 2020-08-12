<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.itutry.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/12
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <c:forEach begin="1" end="10" step="2" var="i">
            <tr><td>${i}</td></tr>
        </c:forEach>
    </table>
<hr/>
<%
    request.setAttribute("arr", new String[]{"18611111111", "18622222222", "18633333333"});
%>
<c:forEach items="${requestScope.arr}" var="item">
    ${item} <br/>
</c:forEach>

<hr/>
<%
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    request.setAttribute("map", map);
%>
<c:forEach items="${requestScope.map.entrySet()}" var="entry">
    ${entry.key} = ${entry.value} <br/>
</c:forEach>

<hr/>
<%
    List<Student> stus = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        stus.add(new Student(i, "username" + i, "password" + i, 18, "phone" + i));
    }
    request.setAttribute("stus", stus);
%>
<table border="1" cellspacing="0">
    <tr>
        <th>学号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>电话</th>
    </tr>
    <c:forEach begin="2" end="7" step="2" varStatus="status" items="${requestScope.stus}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.password}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>${status.index}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
