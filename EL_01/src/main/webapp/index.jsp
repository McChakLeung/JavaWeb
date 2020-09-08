<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/8/31
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key4","本科");
    %>
    <table border="1">
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>居住地</td>
            <td>教育程度</td>
        </tr>
        <tr>
            <td>${applicationScope.key1}</td>
            <td>${sessionScope.key2}</td>
            <td>${requestScope.key3}</td>
            <td>${pageScope.key4}</td>
        </tr>
    </table>
</body>
</html>
