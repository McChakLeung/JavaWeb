package com.dgpalife.controller.question;

import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.List;

public class QuestionScoreServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session,并从session中获取questionList
        HttpSession session = request.getSession(false);
        List<Question> questionList = (List<Question>)session.getAttribute("questionList");
        Integer score = 0;

        //2.比较选择的答案是否与正确的答案一致
        for(Question question : questionList){
            //获得当前问题的id
            Integer id = question.getId();
            //从前端获取对应题目的选择答案（input中的name值是题目id,从而获取该input的value)
            String answer = request.getParameter(String.valueOf(id));
            //判断选择的答案是否为空
            if(answer == null || "".equals(answer)){
                score += 0;
            }else{
                if(answer.equals(question.getAnswer())){
                    score += 40;
                }
            }
        }

        //3.将成绩返回给用户
        response.setCharacterEncoding("GBK");
        response.getWriter().write("您的成绩为：" + score + "分");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
