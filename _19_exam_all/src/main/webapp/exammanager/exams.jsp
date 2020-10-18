<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/10/18
  Time: 12:24
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
    <script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
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

                <c:forEach items="${requestScope.pageBean.dataList}" var="question" varStatus="dl">
                    <p>
							<span style="font-weight: bold; color: #296DB8;">${dl.count}、 ${question.title}</span>

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

                        <a href="/exam/question/findByID.do?id=${question.id}"><span
                                style="color: #FF8005;">编辑</span>
                        </a>&nbsp;&nbsp;
                        <a href="/exam/question/delete.do?id=${question.id}" onclick="delbtn()"><span
                                style="color: #FF8005;">删除</span>
                        </a>]
                    </p>
                </c:forEach>


            </div>


            <div style="margin-top: 10px">
                <input type="button" value="首页" onclick="firstPage()" ${requestScope.pageBean.pageNum eq 1 ? "disabled":""}>
                <input type="button" value="上一页" onclick="prePage()" ${requestScope.pageBean.pageNum eq 1 ? "disabled":""}>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNum eq i}">
                        ${i}
                    </c:if>
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="/exam/question/find.do?pageNum=${i}">${i}</a>
                    </c:if>
                </c:forEach>
                <input type="button" value="下一页" onclick="nextPage()" ${requestScope.pageBean.pageNum eq requestScope.pageBean.totalPage ? "disabled":""}>
                <input type="button" value="尾页" onclick="lastPage()" ${requestScope.pageBean.pageNum eq requestScope.pageBean.totalPage ? "disabled":""}>
                <input type="hidden" value="" name="cp"><br>
                共有${requestScope.pageBean.totalRecord}道题目，共${requestScope.pageBean.totalPage}页，当前为${requestScope.pageBean.pageNum}页, 跳转到
                <select name="selPage" onchange="selectPage()">

                    <c:forEach begin="1" end="${requestScope.pageBean.totalPage}" var="i">
                        <option value="${i}" ${requestScope.pageBean.pageNum eq i?"selected":""}>
                            第${i}页
                        </option>
                    </c:forEach>

                </select>
            </div>
        </div>
        <script type="text/javascript">
            function firstPage() {
                window.location.href = "/exam/question/find.do?pageNum=1";
            }

            function prePage() {
                var currentPage = ${requestScope.pageBean.pageNum - 1};
                window.location.href = "/exam/question/find.do?pageNum=" + currentPage;
            }

            function nextPage() {
                var currentPage = ${requestScope.pageBean.pageNum + 1};
                window.location.href = "/exam/question/find.do?pageNum=" + currentPage;
            }

            function lastPage() {
                var currentPage = ${requestScope.pageBean.totalPage};
                window.location.href = "/exam/question/find.do?pageNum=" + currentPage;
            }

            function selectPage() {
                var currentPage = $("select").val();
                window.location.href = "/exam/question/find.do?pageNum=" + currentPage;
            }
        </script>
    </div>

</div>
</div>
</div>
</body>
</html>

