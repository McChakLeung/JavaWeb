<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<body>
<h2>Hello World!</h2>
</body>
    <table border="1">
        <thead>
            <tr>
                <td>id</td>
                <td>title</td>
                <td>optionA</td>
                <td>optionB</td>
                <td>optionC</td>
                <td>optionD</td>
                <td>answer</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.questionList}" var="question">
                <tr>
                    <td>${question.id}</td>
                    <td>${question.title}</td>
                    <td>${question.optionA}</td>
                    <td>${question.optionB}</td>
                    <td>${question.optionC}</td>
                    <td>${question.optionD}</td>
                    <td>${question.answer}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div><a href="/add.do">新增</a></div>
</html>
