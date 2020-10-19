package com.dgpalife.controller.question;

import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer score = 0;

        //获取session以及QuestionList
        HttpSession session = request.getSession(false);
        List<Question> questionList = (List<Question>)session.getAttribute("questionList");

        //对比结果
        for(Question question : questionList){
            //获取题目的id
            Integer id = question.getId();
            //获取用户选择的答案
            String answer = request.getParameter(String.valueOf(id));
            //判断用户的答案是否为空
            if(answer == null || "".equals(answer)){
                score += 0;
            }else{
                if(answer.equals(question.getAnswer())){
                    score += 40;
                }
            }

        }

        //返回结果给用户
        response.setCharacterEncoding("GBK");
        response.getWriter().write("您的成绩为：" + score + "分");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
