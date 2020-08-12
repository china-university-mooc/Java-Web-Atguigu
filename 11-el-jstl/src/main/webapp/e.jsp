<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/11
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("emptyNull", null);
    request.setAttribute("emptyString", "");
    request.setAttribute("emptyArray", new Object[0]);
    request.setAttribute("emptyList", new ArrayList<>());
    request.setAttribute("emptyMap", new HashMap<>());
%>
${empty emptyNull}<br/>
${empty emptyString}<br/>
${empty emptyArray}<br/>
${empty emptyList}<br/>
${empty emptyMap}<br/>

${12 > 13 ? "大" : "小"}
</body>
</html>
