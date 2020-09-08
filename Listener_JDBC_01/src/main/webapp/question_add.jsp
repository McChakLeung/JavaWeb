<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>添加题目</title>
</head>
<body>
        <center>
           <form action="/add.do">

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
        
        </center>
</body>
</html>