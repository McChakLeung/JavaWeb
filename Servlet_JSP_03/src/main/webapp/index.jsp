<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<body>
<h2>Hello World!</h2>
<%
    String name = (String)application.getAttribute("key1");
    String age = (String)session.getAttribute("key2");
    String location = (String)request.getAttribute("key3");
    out.write(name);
    out.write("<br>");
    out.write(age);
    out.write("<br>");
    out.write(location);
    out.write("<br>");
%>
<table border="1">
    <tr>
        <td>name</td>
        <td>age</td>
        <td>location</td>
    </tr>
    <tr>
        <td><%=name%></td>
        <td><%=age%></td>
        <td><%=location%></td>
    </tr>
</table>
</body>
</html>
