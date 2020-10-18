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
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session对象，并获取questionList
        HttpSession session = request.getSession(false);
        List<Question> questionList = (List<Question>) session.getAttribute("questionList");
        Integer score = 0;

        //2.遍历questionList,获取当前的题目所选择的答案和正确答案是否一致
        for(Question question : questionList){
            //获取当前问题的id
            Integer id = question.getId();
            //通过id，查询前端传入的选择答案
            String answer = request.getParameter(String.valueOf(id));
            //判断当前的答案是否为空，如果为空则+0分，如果不为空则判断答案是否正确
            if(answer == null || "".equals(answer)){
                score += 0;
            }else{
                if(answer.equals(question.getAnswer())){
                    score += 40;
                }
            }

        }

        //3.将当前的答案展示给用户
        response.setCharacterEncoding("GBK");
        response.getWriter().write("您的得分为：" + score + "分");

    }
}
