<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/9/6
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <title>Insert title here</title>
    <link href="../style/style.css" rel="stylesheet" type="text/css" />
    <script>
        function delbtn(){
            if(confirm('确定要删除吗')){

            }
        }
    </script>

</head>
<body style="overflow: scroll; overflow-y: hidden">
<div>

    <div id="ks">
        <!--ks_top-->
        <div class="main_top">
            <p>
                试题管理
            </p>
        </div>
        <!--ks_bottom-->
        <div class="ks_bottom">

            <!--ti-->
            <div class="ti">

                <c:forEach items="${requestScope.questionList}" var="question" >
                    <p>
							<span style="font-weight: bold; color: #296DB8;">${question.id}、 ${question.title}</span>

                    </p>

                    <p>
                    <div id="ispan3" align="left" style="padding-left: 36px">
                        <span name="option" style="font-weight: bold;">A、${question.optionA}</span>
                        <span name="option"
                              style="font-weight: bold; padding-left: 120px">B、${question.optionB}</span>
                        <span name="option"
                              style="font-weight: bold; padding-left: 120px">C、${question.optionC}</span>
                        <span name="option"
                              style="font-weight: bold; padding-left: 120px">D、${question.optionD}</span>

                    </div>
                    </p>
                    <p style="padding-left: 36px">
                        (答案是:&nbsp;
                        <span id="an3" style="font-weight: bold; color: #F80015;">${question.answer}</span>&nbsp;)&nbsp;&nbsp;&nbsp;[

                        <a href="/exam/question/findById.do?id=${question.id}"><span
                                style="color: #FF8005;">编辑</span>
                        </a>&nbsp;&nbsp;
                        <a href = "/exam/question/delete.do?id=${question.id}" ><span
                                style="color: #FF8005;">删除</span>
                        </a>]
                    </p>
                </c:forEach>


            </div>


            <div style="margin-top: 10px">
                <input type="button" value="首页" onclick="javascript:void(0)" disabled>
                <input type="button" value="上一页" onclick="javascript:void(0)" disabled>
                <input type="button" value="下一页" onclick="javascript:void(0)">
                <input type="button" value="尾页" onclick="javascript:void(0)">
                <input type="hidden" value="" name="cp">
                <font color="red"> 1</font> /
                <font color="red"> 2</font> 跳转到
                <select name="selPage" onchange="javascript:void(0)">

                    <option value="1" selected>
                        1
                    </option>

                    <option value="2">
                        2
                    </option>

                </select>
            </div>
        </div>

    </div>

</div>
</div>
</div>
</body>
</html>

