<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/10
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    声明属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;
%>
<%!
    static {
        map = new HashMap<>();
        map.put("key", "value");
    }
%>
<%!
    public int foo() {
        return 12;
    }
%>
<%!
    public static class A {
        private Integer id = 12;
        private String abc = "abc";
    }
%>

<%=12 %>
<%=12.12 %>
<%="我是字符串" %>
<%=map %>
<%=request.getParameter("username") %>

<%
    int i = 13;
    if (i == 12) {
        System.out.println("国哥好帅！！！");
    } else {
        System.out.println("国哥又骗人了");
    }
%>
<%
    for (int j = 0; j < 10; j++) {
        System.out.println(j);
    }
%>
<br/>
<%
    for (int j = 0; j < 10; j++) {
%>
    <%=j %><br/>
<%
    }
%>
<%
    String username = request.getParameter("username");
    System.out.println("用户名为：" + username);
%>

<table border="1" cellspacing="0">
<%
    for (int j = 0; j < 10; j++) {
%>
    <tr>
        <td>第<%=j + 1 %>行</td>
    </tr>
<%
    }
%>
</table>

<%
    int i1 = 13;
    if (i1 == 12) {
%>
    <h2>国哥好帅！！！</h2>
<%
    } else {
%>
    <h2>国哥又骗人了</h2>
<%
    }
%>
</body>
</html>
