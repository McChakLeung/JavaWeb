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
        //1.获取Session，并从session中获取questionList
        HttpSession session = request.getSession(false);
        List<Question> questionList = (List<Question>) session.getAttribute("questionList");
        Integer score = 0;

        //2.将用户选择的答案与正确答案相比较，计算分数
        for(Question question : questionList){
            //获取当前的题目的id
            Integer id = question.getId();
            //获取从前端传入的选择答案
            String answer = request.getParameter(String.valueOf(id));
            //判断传入的答案是否为空
            if(answer==null || "".equals(answer)){
                score += 0;
            }else{
                //判断选择的答案是否与正确答案一致
                if(answer.equals(question.getAnswer())){
                    score += 40;
                }
            }
        }

        //3.将结果返回给用户
        response.setCharacterEncoding("GBK");
        response.getWriter().write("您的成绩为：" + score + "分");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
