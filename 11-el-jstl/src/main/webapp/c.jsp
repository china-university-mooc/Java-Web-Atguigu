<%@ page import="com.itutry.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: zhaozhang
  Date: 2020/8/11
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("张三");
    person.setPhones(new String[]{"1111111", "2222222", "3333333"});

    List<String> cities = new ArrayList<>();
    cities.add("北京");
    cities.add("深圳");
    cities.add("上海");
    person.setCities(cities);

    Map<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    person.setMap(map);

    pageContext.setAttribute("person", person);
%>
输出Person: ${person}<br/>
输出Person的name属性：${person.name}<br/>
输出Person的phones属性：${person.phones[0]}<br/>
输出Person的cities属性：${person.cities[0]}<br/>
输出Person的map属性：${person.map["key1"]}<br/>
输出Person的map属性：${person.map.key1}<br/>
输出Person的age属性：${person.age}<br/>
</body>
</html>
