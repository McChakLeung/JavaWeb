<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/10/18
  Time: 17:31
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
</head>

<div class="right_f">


    <script type="text/javascript">

    </script>
    <!--right-->
    <div id="right">
        <!--right_top-->
        <div class="right_top">
            <p>
                用户信息
            </p>
        </div>

        <div class="right_bottom">
            <!--							<h1>-->
            <!--								<span style="text-align: center; padding-left: 120px;">用户注册</span>-->
            <!--							</h1>-->
            <!--nr-->
            <!--baise-->
            <div class="baise">
                <form action="/exam/user/update.do" method="get">
                <table width="100%" class="table" cellspacing="1"
                       style="background: #FFFFFF; font-size: 12px; text-align: center; margin: 0 auto; border: 0;">


                    <tr style="background: #FFFFFF; border: 0;">
                        <td height="20" align="right" width="46%">
                            用户名称：
                        </td>
                        <td width="54%" style="text-align: left; padding-left: 10px;">
                            <input id="username" name="username" type="text"
                                   maxlength="20"
                                   style="width: 165px; padding-left: 5px; border: none; border: solid 1px #C4D0CC;"
                                   value="${requestScope.user.username}" />

                            <span id="responseInfo" style="color: red"></span>
                            <font color='red'>*</font>
                        </td>

                    </tr>
                    <tr
                            style="background: #FFFFFF; border: 0; margin-top: 10px; height: 25px;">
                        <td style="width:auto ;" align="right">
                            密码：
                        </td>
                        <td style="text-align: left; padding-left: 10px;">
                            <input id="password" name="password" type="text"
                                   maxlength="20"
                                   style="width: 165px; padding-left: 5px; border: none; border: solid 1px #C4D0CC;"
                                   value="" />
                            <font color='red'>*</font>
                        </td>

                    </tr>


                    <tr
                            style="background: #FFFFFF; border: 0; margin-top: 10px; height: 25px;">
                        <td style="width: ;" align="right">
                            密码确认：
                        </td>
                        <td style="text-align: left; padding-left: 10px;">
                            <input id="confirmPWd" name="confirmPWd" type="text"
                                   maxlength="20"
                                   style="width: 165px; padding-left: 5px; border: none; border: solid 1px #C4D0CC;"
                                   value="" />
                            <font color='red'>*</font>
                        </td>
                    </tr>

                    <tr
                            style="background: #FFFFFF; border: 0; margin-top: 10px; height: 25px;">

                        <td align="right">
                            邮箱：
                        </td>
                        <td style="text-align: left; padding-left: 10px;">
                            <input id="email" name="email" type="text" maxlength="20"
                                   style="width: 165px; padding-left: 5px; border: none; border: solid 1px #C4D0CC;"
                                   value="${requestScope.user.email}" />
                            <font color='red'>*</font>
                        </td>
                    </tr>

                    <tr
                            style="background: #FFFFFF; border: 0; margin-top: 10px; height: 25px;">
                        <td align="right">

                            电话：
                        </td>

                        <td style="text-align: left; padding-left: 10px;">
                            <input id="tel" name="telephone" type="text" maxlength="20"
                                   style="width: 165px; padding-left: 5px; border: none; border: solid 1px #C4D0CC;"
                                   value="${requestScope.user.telephone}" />
                            <font color='red'>*</font>
                        </td>
                    </tr>
                    <tr
                            style="background: #FFFFFF; border: 0; margin-top: 10px; height: 25px;">
                        <td align="right">

                        </td>
                        <td style="text-align: left; padding-left: 10px;">
                            <input type="hidden" name="id" value="${requestScope.user.id}">
                            <input name="" value="重新填写" type="button"
                                   style="background: none; border: 0; width: 54px; height: 20px; background-color: #B6DDFC;" />
                            <input name="" value="提交信息" type="submit"
                                   style="background: none; border: 0; width: 54px; height: 20px; background-color: #B6DDFC; margin-left: 15px;" />


                        </td>
                    </tr>

                </table>
                </form>

                <script type="text/javascript">
                    document.getElementById("username").focus();
                </script>
            </div>
        </div>
    </div>

</div>
</div>
</div>
</body>
</html>
