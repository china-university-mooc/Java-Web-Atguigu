<%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/11
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key", "value");
    %>
    表达式脚本输出key的值是：<%=request.getAttribute("key")%><br/>
    EL表达式输出key的值是：${key}

    <br/>
    表达式脚本输出key1的值是：<%=request.getAttribute("key1") == null ? "" : request.getAttribute("key")%><br/>
    EL表达式输出key1的值是：${key1}
</body>
</html>
