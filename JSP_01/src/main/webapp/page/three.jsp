<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/8/21
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="/">
</head>
<body>
    <center>
        <h1>使用绝对路径访问jsp文件</h1>
        <a href="one.jsp">one.jsp</a><br/>
        <a href="page/two.jsp">two.jsp</a><br/>
        <a href="page/sub/four.jsp">four.jsp</a><br/>

        <h1>使用相对路径访问jsp文件</h1>
        <a href="../one.jsp">one.jsp</a><br/>
        <a href="two.jsp">two.jsp</a><br/>
        <a href="sub/four.jsp">four.jsp</a><br/>
    </center>
</body>
</html>
