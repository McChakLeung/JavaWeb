<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/10/18
  Time: 15:03
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
            //1.单击全选按钮，会影响到数据行的checkbox状态
            $(":checkbox:first").click(fun1);

            //2.数据行的数据反向影响全选按钮
            $(":checkbox:gt(0)").click(fun2);

            //3.鼠标mouseover事件
            $("table tr:gt(0)").mouseover(fun3)

            //4.鼠标mouseout事件
            $("table tr:gt(0)").mouseout(fun4)

        })


        function fun1() {
            var flag = $(":checkbox:first").prop("checked");
            if(flag){
                $(":checkbox:gt(0)").prop("checked",true);
            }else{
                $(":checkbox:gt(0)").prop("checked",false);
            }
            fun5()
        }

        function fun2() {
            //获取当前已选择的行数
            var selected = $(":checkbox:gt(0):checked").length;
            //获取所有行数
            var total = $(":checkbox:gt(0)").length;
            //对比这两个数字是否一致，如果一致，则影响标题行全选按钮
            if(selected == total){
                $(":checkbox:first").prop("checked",true);
            }else{
                $(":checkbox:first").prop("checked",false);
            }
            fun5()
        }

        function fun3() {
            $(this).css("backgroundColor","red");
        }

        function fun4() {
            $(this).css("backgroundColor","white");
        }

        //影响删除和更新的状态
        function fun5() {
            //获取所选择的行数
            var select = $(":checkbox:gt(0):checked").length;
            //判断各种情况下删除和更新按钮的状态
            if(select <= 0){
                $("#updateBtn").prop("disabled",true);
                $("#deleteBtn").prop("disabled",true);
            }else if(select == 1){
                $("#updateBtn").prop("disabled",false);
                $("#deleteBtn").prop("disabled",false);
            }else{
                $("#updateBtn").prop("disabled",true);
                $("#deleteBtn").prop("disabled",false);
            }
        }

        function deleteUser(){
            if(confirm("确定要删除这些数据吗？")){
                fun6();
            }
        }

        //异步批量删除这些数据
        function fun6() {
            //获取选择的数据，并组装成一个数组
            var params = null;
            $(":checkbox:gt(0):checked").each(function (index,domObj) {
                if(params == null){
                    params = "id=" + $(domObj).val();
                }else{
                    params = params + "&id=" + $(domObj).val();
                }
            })
            //将这些数据组装到ajax中
            $.get(
                "/exam/user/delete.do",
                params,
                fun7(),
                "text"
            )
        }

        function fun7(data) {
            if(data == 0){
                alert("删除错误，请联系管理员处理")
            }else{
                $(":checkbox:gt(0):checked").each(function (index,domObj) {
                    $(domObj).parent().parent().parent().remove();
                })
            }
        }

        function updateUser() {
            var id = $(":checkbox:gt(0):checked").val();
            window.location = "/exam/user/findByID.do?id=" + id;
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
						<input type="button" value="修改" id="updateBtn" disabled onclick="updateUser()" style="width: 54px; height: 20px; margin-left: 15px;">
						<input type="button" value="删除" id="deleteBtn" disabled onclick="deleteUser()" style="width: 54px; height: 20px; margin-left: 15px;">
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

                <c:forEach items="${requestScope.pageBean.dataList}" var="user" varStatus="ul">
                    <tr
                            style="background: #FFFFFF; border: 0; text-align: center; line-height: 25px;">
                        <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
                            <input name="checkbox" type="checkbox" class="STYLE2" value="${user.id}" />
                        </div></td>

                        <td style="color: #666666; font-size: 14px;">
                            ${ul.count}
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
                <input type="button" value="首页" onclick="firstPage()" ${requestScope.pageBean.pageNum eq 1 ? "disabled" : ""}>
                <input type="button" value="上一页" onclick="prePage()" ${requestScope.pageBean.pageNum eq 1 ? "disabled" : ""}>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" var="i" step="1">
                    <c:if test="${requestScope.pageBean.pageNum eq i}">
                        ${i}
                    </c:if>
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="/exam/user/find.do?pageNum=${i}">${i}</a>
                    </c:if>
                </c:forEach>
                <input type="button" value="下一页" onclick="nextPage()" ${requestScope.pageBean.pageNum eq requestScope.pageBean.totalPage ? "disabled" : ""}>
                <input type="button" value="尾页" onclick="lastPage()" ${requestScope.pageBean.pageNum eq requestScope.pageBean.totalPage ? "disabled" : ""}>
                <input type="hidden" name="cp">
                共有${requestScope.pageBean.totalRecord}个用户，共${requestScope.pageBean.totalPage}页，当前为${requestScope.pageBean.pageNum}页, 跳转到
                <select name="selPage" onchange="selectPage()">
                    <c:forEach begin="1" end="${requestScope.pageBean.totalPage}" var="i" step="1">
                        <option value="${i}" ${requestScope.pageBean.pageNum eq i ? "selected":""}>
                            第${i}页
                        </option>
                    </c:forEach>
                </select>
            </div>


        </div>
    </div>
    <script type="text/javascript">
        function firstPage() {
            window.location.href = "/exam/user/find.do?pageNum=1";
        }

        function prePage() {
            var currentPage = ${requestScope.pageBean.pageNum - 1};
            window.location.href = "/exam/user/find.do?pageNum=" + currentPage;
        }

        function nextPage() {
            var currentPage = ${requestScope.pageBean.pageNum + 1};
            window.location.href = "/exam/user/find.do?pageNum=" + currentPage;
        }

        function lastPage() {
            var currentPage = ${requestScope.pageBean.totalPage};
            window.location.href = "/exam/user/find.do?pageNum=" + currentPage;
        }

        function selectPage() {
            var currentPage = $("select").val();
            window.location.href = "/exam/user/find.do?pageNum=" + currentPage;
        }

    </script>

</div>
</div>
</div>
</body>
</html>

