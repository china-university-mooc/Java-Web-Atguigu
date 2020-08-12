<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/12
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    保存之前：${requestScope.abc} <br/>
    <c:set scope="request" var="abc" value="abcValue" />
    保存之后：${requestScope.abc} <br/>

    <c:if test="${12 == 12}">
        <h1>12等于12</h1>
    </c:if>

    <hr/>
    <c:set scope="request" var="height" value="168" />
    <c:choose>
<%--        <!--html注释不能使用在这里-->--%>
        <%--应该使用jsp注释--%>
        <c:when test="${height > 190}">
            <h2>小巨人</h2>
        </c:when>
        <c:when test="${height > 180}">
            <h2>很高</h2>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${height > 170}">
                    <h2>还可以</h2>
                </c:when>
                <c:otherwise>
                    <h2>剩下小于160的情况</h2>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
</body>
</html>
