<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/9/19
  Time: 21:09
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
    <script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function () {
            //1.标题行checkbox绑定点击事件，影响数据行ck状态
            $(":checkbox:first").click(fun1);
            //2.数据行checkbox绑定点击事件，影响标题行ck状态
            $(":checkbox:gt(0)").click(fun2);
            //3.数据行绑定mouseover事件，改变颜色
            $("table tr:gt(0)").mouseover(fun3);
            //4.数据行绑定mouseout事件，改变颜色
            $("table tr:gt(0)").mouseout(fun4);
        })

        function fun1() {
            var flag = $(":checkbox:first").prop("checked");
            if(flag){
                $(":checkbox:gt(0)").prop("checked",true);
            }else{
                $(":checkbox:gt(0)").prop("checked",false);
            }
            fun5();
        }

        function fun2() {
            var num1 = $(":checkbox:gt(0)").length;
            var num2 = $(":checkbox:gt(0):checked").length;
            if(num1 == num2){
                $(":checkbox:first").prop("checked",true);
            }else{
                $(":checkbox:first").prop("checked",false);
            }
            fun5();
        }

        function fun3() {
            $(this).css("backgroundColor","red");
        }

        function fun4() {
            $(this).css("backgroundColor","white");
        }

        //处理点击多选框时更新和删除按钮的状态
        function fun5() {
            var num = $(":checkbox:gt(0):checked").length;
            if(num == 0){
                $("#updateBtn").prop("disabled",true);
                $("#deleteBtn").prop("disabled",true);
            }else if(num == 1){
                $("#updateBtn").prop("disabled",false);
                $("#deleteBtn").prop("disabled",false);
            }else{
                $("#updateBtn").prop("disabled",true);
                $("#deleteBtn").prop("disabled",false);
            }
        }

        function deleteUser(){
            if(confirm("确定删除这些数据吗？")){
                fun6()
            }
        }

        //批量删除
        function fun6() {
            var params = null;
            $(":checkbox:gt(0):checked").each(function (index,domObj) {
                if(params==null){
                    params = "id=" + $(domObj).val();
                }else{
                    params = params + "&id=" + $(domObj).val();
                }
            })

            $.get(
                "/exam/usermanager/delete.do",
                params,
                fun7(),
                "text"
            )

            function fun7(data) {
                if(data=='0'){
                    alert("删除错误，请联系管理员处理")
                }else{
                    $(":checkbox:gt(0):checked").parent().parent().parent().remove();
                }
            }
        }

        //更新数据
        function updateUser() {
            var id = $(":checkbox:gt(0):checked").val();
            window.location.href="/exam/usermanager/findById.do?id=" + id;
        }
    </script>
</head>
<!-- 去除纵向滚动条  style="overflow:scroll;overflow-y:hidden" -->
<body style="overflow: scroll; overflow-y: hidden">
<div>


    <div id="main">
        <!--main_top-->
        <div class="user_manager">
            <p>
                用户管理
                <span style="float: right;margin-right: 20px">
						<input type="button" value="添加" onclick="document.location='/usermanager/userAdd.html'" style="width: 54px; height: 20px; margin-left: 15px;">
						<input type="button" value="修改" disabled id="updateBtn" onclick="updateUser()"  style="width: 54px; height: 20px; margin-left: 15px;">
						<input type="button" value="删除" disabled id="deleteBtn" onclick="deleteUser()" style="width: 54px; height: 20px; margin-left: 15px;">
						</span>
            </p>
        </div>
        <!--main_bottom-->

        <div class="main_bottom">

            <table width="100%" class="table" cellspacing="1"
                   style="background: #BAC2CF; font-size: 14px;">
                <tr
                        style="background: #F6F6F6; border: 0; text-align: center; line-height: 25px;">
                    <td width="6%" height="26" background="../images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1"><input type="checkbox" name="checkbox62" value="checkbox" /></div></td>

                    <td
                            style="color: #2B67D7; font-size: 14px; text-align: center; font-weight: bold;">
                        编号
                    </td>
                    <td
                            style="color: #2B67D7; font-size: 14px; text-align: center; font-weight: bold;">
                        用户名称
                    </td>
                    <td
                            style="color: #2B67D7; font-size: 14px; text-align: center; font-weight: bold;">
                        邮箱
                    </td>
                    <td
                            style="color: #2B67D7; font-size: 14px; text-align: center; font-weight: bold;">
                        电话
                    </td>
                    <td
                            style="color: #2B67D7; font-size: 14px; text-align: center; font-weight: bold;">
                        时间
                    </td>


                </tr>

                <c:forEach items="${requestScope.userList}" var="user">
                    <tr
                            style="background: #FFFFFF; border: 0; text-align: center; line-height: 25px;">
                        <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
                            <input name="checkbox" type="checkbox" class="STYLE2" value="${user.id}" />
                        </div></td>

                        <td style="color: #666666; font-size: 14px;">
                            ${user.id}
                        </td>
                        <td style="color: #666666; font-size: 14px; text-align: center;">
                            ${user.username}
                        </td>
                        <td style="color: #666666; font-size: 14px; text-align: center;">
                            ${user.email}
                        </td>
                        <td style="color: #666666; font-size: 14px; text-align: center;">
                            ${user.telephone}
                        </td>
                        <td style="color: #666666; font-size: 14px; text-align: center;">

                            ${user.registDate}
                        </td>
                    </tr>

                </c:forEach>


            </table>
            <div>
                <input type="button" value="首页" onclick="firstPage()" ${requestScope.pageNum eq 1?"disabled":""} >
                <input type="button" value="上一页" onclick="prePage()" ${requestScope.pageNum eq 1?"disabled":""} >
                <input type="button" value="下一页" onclick="nextPage()" ${requestScope.pageNum eq requestScope.totalPage?"disabled":""}>
                <input type="button" value="尾页" onclick="lastPage()" ${requestScope.pageNum eq requestScope.totalPage?"disabled":""}>
                <input type="hidden" name="cp">
                <span style="color: red"> ${requestScope.pageNum} / ${requestScope.totalPage} </span> 跳转到：
                <select name="selPage" onchange="changePage()" >

                    <c:forEach var="i" begin="1" end="${requestScope.totalPage}">
                        <option value="${i}" ${requestScope.pageNum eq i?"selected":""}>
                               第${i}页
                        </option>
                    </c:forEach>

                </select>
            </div>
            <script type="text/javascript">
                function firstPage() {
                    window.location = "/exam/usermanager/find.do?pageNum=1";
                }

                function prePage() {
                    var currentPage = ${requestScope.pageNum-1};
                    window.location = "/exam/usermanager/find.do?pageNum=" + currentPage;
                }

                function nextPage() {
                    var currentPage = ${requestScope.pageNum+1};
                    window.location = "/exam/usermanager/find.do?pageNum=" + currentPage;
                }

                function lastPage() {
                    var currentPage = ${requestScope.totalPage};
                    window.location = "/exam/usermanager/find.do?pageNum=" + currentPage;
                }

                //调整下拉列表的页数
                function changePage() {
                    var currentPage = $("select").val();
                    window.location = "/exam/usermanager/find.do?pageNum=" + currentPage;
                }

            </script>

        </div>
    </div>


</div>
</div>
</div>
</body>
</html>

