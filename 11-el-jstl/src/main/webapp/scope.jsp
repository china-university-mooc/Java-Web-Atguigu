<%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/11
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
pageContext域的key值: ${pageScope.key}<br/>
request域的key值: ${requestScope.key}<br/>
session域的key值: ${sessionScope.key}<br/>
application域的key值: ${applicationScope.key}<br/>
</body>
</html>
