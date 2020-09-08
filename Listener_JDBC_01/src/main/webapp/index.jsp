<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<title>题目列表</title>
<body>
    <form>
        <table border="1">
            <thead>
                <tr>
                    <td>序号</td>
                    <td>题目</td>
                    <td>选项A</td>
                    <td>选项B</td>
                    <td>选项C</td>
                    <td>选项D</td>
                    <td>答案</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.questionList}" var="question">
                    <tr>
                        <td>${question.id }</td>
                        <td>${question.title }</td>
                        <td>${question.optionA }</td>
                        <td>${question.optionB }</td>
                        <td>${question.optionC }</td>
                        <td>${question.optionD }</td>
                        <td>${question.answer }</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>
</body>
</html>
