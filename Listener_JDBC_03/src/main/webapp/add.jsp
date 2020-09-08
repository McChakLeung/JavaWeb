<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/8/17
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="get" action="/doAdd.do">
        试题信息:<input type="text" name="title"/><br/>
        A:<input type="text" name="optionA"/><br/>
        B:<input type="text" name="optionB"/><br/>
        C:<input type="text" name="optionC"/><br/>
        D:<input type="text" name="optionD"/><br/>
        正确答案:<input type="radio" name="answer" value="A">A
        <input type="radio" name="answer" value="B">B
        <input type="radio" name="answer" value="C">C
        <input type="radio" name="answer" value="D">D<br/>
        <input type="submit" value="添加试题">
    </form>
</body>
</html>
