<%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/11
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
1. 获取协议: ${pageContext.request.scheme}<br/>
2. 获取服务器主机名 ip: ${pageContext.request.serverName}<br/>
3. 获取服务器端口: ${pageContext.request.serverPort}<br/>
4. 获取工程路径: ${pageContext.request.contextPath}<br/>
5. 获取请求方法: ${pageContext.request.method}<br/>
6. 获取客户端 ip 地址: ${pageContext.request.remoteHost}<br/>
7. 获取会话的 id 编号: ${pageContext.session.id}<br/>
</body>
</html>
