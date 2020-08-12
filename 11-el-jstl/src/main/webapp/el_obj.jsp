<%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/12
  Time: 00:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--http://localhost:8080/11_el_jstl/el_obj.jsp?username=tom&hobbies=c++&hobbies=java--%>
输出请求参数username的值：${param.username} <br/>
输出请求参数hobbies的值：${paramValues.hobbies[0]} <br/>
输出请求参数hobbies的值：${paramValues.hobbies[1]} <br/>

输出请求头User-Agent的值：${header["User-Agent"]} <br/>
输出请求头Connection的值：${header.Connection} <br/>
输出请求头User-Agent的值：${headerValues["User-Agent"][0]} <br/>

获取Cookie JSESSIONID的名称：${cookie.JSESSIONID.name} <br/>
获取Cookie JSESSIONID的值：${cookie.JSESSIONID.value} <br/>

获取initParam url的值：${initParam.url} <br/>
</body>
</html>
