<%--
  Created by IntelliJ IDEA.
  User: McChakLeung
  Date: 2020/9/3
  Time: 22:58
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
    <script type="text/javascript" src="/js/jquery-3.3.1.js" ></script>
    <script type="text/javascript">
        $(function () {
            $(':radio').each(function (index,domObj) {
                if($(domObj).val() == '${requestScope.question.answer}'){
                    $(domObj).prop("checked",true);
                    return;
                }
            })
        })

    </script>
</head>
<!-- 去除纵向滚动条  style="overflow:scroll;overflow-y:hidden" -->
<body style="overflow: scroll; overflow-y: hidden">
<div>

    <div id="right">
        <!--right_top-->
        <div class="right_top">
            <p>
                试题修改
            </p>
        </div>
        <div class="right_bottom" style="border: 0px solid red;">

            <!--					<h1>-->
            <!--						<span style="text-align: center; padding-left: 120px;">考试题</span>-->
            <!--					</h1>-->
            <!--nr-->
            <!--baise-->
            <div class="baise" >

                <form id="form1" name="form1" method="get"
                      action="/exam/question/update.do">
                    <input type="hidden" name="command" value="add">
                    <table width="10%" class="table" cellspacing="1"
                           style="background: #FFFFFF; font-size: 12px;  margin: 0 auto; border: 0;">


                        <tr style="background: #FFFFFF; border: 0;">
                            <td nowrap="nowrap" height="30" align="right" width="46%">
                                <span style="font-weight: bold; color: #296DB8;">题目 :</span>
                            </td>
                            <td width="54%" style="text-align: left; padding-left: 10px;">
                                <textarea name="title" cols="100">${requestScope.question.title}</textarea>

                            </td>
                        </tr>

                        <tr
                                style="background: #FFFFFF; border: 1; margin-top: 10px; height: 25px;">
                            <td style="width: ;" align="right">
                                <span style="font-weight: bold; color: #296DB8;">A,</span>
                            </td>
                            <td style="text-align: left; padding-left: 10px;">
                                <input id="option1" name="optionA" type="text" maxlength="20"
                                       style="width: 800px; padding-left: 5px; border: none; border: solid 1px #C4D0CC;"
                                       value="${requestScope.question.optionA}" />
                            </td>

                        </tr>

                        <tr
                                style="background: #FFFFFF; border: 0; margin-top: 10px; height: 25px;">
                            <td style="width: ;" align="right">
                                <span style="font-weight: bold; color: #296DB8;">B,</span>
                            </td>
                            <td style="text-align: left; padding-left: 10px;">
                                <input id="option2" name="optionB" type="text" maxlength="20"
                                       style="width: 800px; padding-left: 5px; border: none; border: solid 1px #C4D0CC;"
                                       value="${requestScope.question.optionB}" />
                            </td>
                        </tr>

                        <tr
                                style="background: #FFFFFF; border: 0; margin-top: 10px; height: 25px;">
                            <td align="right">
                                <span style="font-weight: bold; color: #296DB8;">C,</span>
                            </td>
                            <td style="text-align: left; padding-left: 10px;">
                                <input id="option3" name="optionC" type="text" maxlength="20"
                                       style="width: 800px; padding-left: 5px; border: none; border: solid 1px #C4D0CC;"
                                       value="${requestScope.question.optionC}" />
                            </td>
                        </tr>
                        <tr
                                style="background: #FFFFFF; border: 0; margin-top: 10px; height: 25px;">

                            <td height="20" align="right">
                                <span style="font-weight: bold; color: #296DB8;">D,</span>
                            </td>
                            <td style="text-align: left; padding-left: 10px;">
                                <input name="optionD" type="text" id="option4"
                                       style="width: 800px; padding-left: 5px; border: none; border: solid 1px #C4D0CC;"
                                       value="${requestScope.question.optionD}" size="300" maxlength="200" />
                            </td>
                        </tr>

                        <tr
                                style="background: #FFFFFF; border: 0; margin-top: 10px; height: 25px;">
                            <td height="112" align="right">

                            </td>
                            <td align="center" valign="middle"
                                style="text-align: left; padding-left: 10px;">
                                <p>
                                    <span style="font-weight: bold; color: #296DB8;">请选择正确答案：</span>
                                </p>
                                <p>
                                    &nbsp;
                                </p>

                                <p style="padding-left: 20px">

                                    <input type="radio" name="answer" value="A"
                                           id="RadioGroup1_0" />
                                    A

                                    <input type="radio" name="answer" value="B"
                                           id="RadioGroup1_1" />
                                    B

                                    <input type="radio" name="answer" value="C"
                                           id="RadioGroup1_2" />
                                    C

                                    <input type="radio" name="answer" value="D"
                                           id="RadioGroup1_3" />
                                    D
                                </p>

                                <p>
                                    &nbsp;
                                </p>
                                <p>


                                    <input type="hidden" name="id" value="${requestScope.question.id}">
                                    <input name="input" value="清除" type="reset"
                                           style="background: none; border: none; width: 70px; height: 23px; background: url(/images/button.jpg) no-repeat; color: #FFFFFF; font-size: 14px;"
                                    />
                                    <input name="input" value="确定" type="submit"
                                           style="background: none; border: none; width: 70px; height: 23px; background: url(/images/button.jpg) no-repeat; color: #FFFFFF; font-size: 14px;"
                                    />
                                    <br />
                                </p>

                                <div></div>
                            </td>
                        </tr>

                    </table>
                </form>
            </div>
        </div>

    </div>
</div>
</div>
</div>
</body>
</html>

