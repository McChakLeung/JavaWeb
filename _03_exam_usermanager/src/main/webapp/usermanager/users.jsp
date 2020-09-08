<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/9/8
  Time: 23:26
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

    <script type="text/javascript">
        function deleteUser(){
            if(confirm("确定删除")){

            }else{
                return false;
            }
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
						<input type="button" value="修改"   style="width: 54px; height: 20px; margin-left: 15px;">
						<input type="button" value="删除" onclick="confirm('确定要删除吗')" style="width: 54px; height: 20px; margin-left: 15px;">
						</span>
            </p>
        </div>
        <!--main_bottom-->

        <div class="main_bottom">

            <table width="100%" class="table" cellspacing="1"
                   style="background: #BAC2CF; font-size: 14px;">
                    <tr
                        style="background: #F6F6F6; border: 0; text-align: center; line-height: 25px;">
                    <td width="6%" height="26" background="../images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1"><input type="checkbox" name="ck" value="checkbox" /></div></td>

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
                            <input name="checkbox" type="checkbox" class="STYLE2" value="checkbox" />
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
                <input type="button" value="首页" onclick="javascript:void(0)" disabled>
                <input type="button" value="上一页" onclick="javascript:void(0)" disabled>
                <input type="button" value="下一页" onclick="javascript:void(0)">
                <input type="button" value="尾页" onclick="javascript:void(0)">
                <input type="hidden" name="cp">
                <span style="color: red"> 1 / 2 </span> 跳转到：
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

