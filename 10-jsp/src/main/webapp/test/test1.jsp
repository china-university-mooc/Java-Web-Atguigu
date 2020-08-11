<%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/11
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table {
            width: 750px;
        }
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
<%--    1 x 1 = 1--%>
<%--    1 x 2 = 2 2 x 2 = 4--%>
<%--    ...--%>
<%--    1 x 9 = 9 ... 9 x 9 = 81--%>
<%--<%
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= i ; j++) {
%>
<%=j + " x " + i + " = " + (i * j)%>&nbsp;&nbsp;
<%
    }
%>
<br/>
<%
    }
%>--%>
    <h1>九九乘法口诀表</h1>
    <table align="center">
    <% for (int i = 1; i <= 9; i++) { %>
        <tr>
        <% for (int j = 1; j <= i ; j++) { %>
            <td><%=j + " x " + i + " = " + (i * j)%></td>
        <%}%>
        </tr>
    <% } %>
    </table>
</body>
</html>
