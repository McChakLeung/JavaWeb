<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/10/17
  Time: 23:35
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
    <link href="/style/style.css" rel="stylesheet" type="text/css" />
</head>
<body style="overflow: scroll; overflow-y: hidden">
<div>
    <!--ks 59616911-->
    <script>

        window.onload = countTime;
        var timeLeft = 1 * 10 * 1000;
        function countTime() {
            var startMinutes = parseInt(timeLeft / (10 * 1000), 10);
            var startSec = parseInt((timeLeft - startMinutes * 10 * 1000) / 1000);
            document.getElementById('time').innerHTML = "剩余时间： " + startMinutes + "分钟 "
                + startSec + "秒 ";
            timeLeft = timeLeft - 1000;
            var t = setTimeout('countTime() ', 1000);

            if (timeLeft == 0) {
                alert("时间到，已自动交卷");
                document.getElementsByName("examsItem")[0].submit();

            }
        }
    </script>
    <div id="ks">
        <!--ks_top-->
        <div class="ks_top">
            <p>
                考试
                <span id='time' style="color: red; padding-left: 600px"></span>
            </p>

        </div>


        <!--ks_bottom-->
        <div class="ks_bottom">
            <div class="ti">
                <form name="examsItem"
                      action="/exam/question/score.do" method="post">

                    <input type="hidden" name="itemSize" value="8">

                    <c:forEach items="${sessionScope.questionList}" var="question" varStatus="ql">
                        <p>
                            <span style="font-weight: bold; color: #296DB8;">${ql.count}、</span> ${question.title}
                        </p>
                        <input type="hidden" name="id0" value="36">
                        <p>


                        <div align="left" id="ispan0"
                             style="padding-left: 31px; font-weight: bold;">
                            <input type="radio" name="${question.id}"
                                   value="A" id="a0">
                            <span> A、${question.optionA}</span>
                            <br>
                            <br>
                            <input type="radio" name="${question.id}"
                                   value="B" id="b0">
                            <span> B、${question.optionB}</span>

                            <br>
                            <br>
                            <input type="radio" name="${question.id}"
                                   value="C" id="c0">
                            <span> C、${question.optionC}</span>
                            <br>
                            <br>
                            <input type="radio" name="${question.id}"
                                   value="D" id="d0">
                            <span> D、${question.optionD}</span>
                        </div>
                        </p>

                    </c:forEach>

                    <input type="submit" value="交     卷" >
                </form>
            </div>

        </div>

    </div>

</div>
</div>
</div>
</body>
</html>

