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
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.从request中获取session，并获取questionList
        HttpSession session = request.getSession(false);
        List<Question> questionList = (List<Question>)session.getAttribute("questionList");
        Integer score = 0;

        //2.遍历questionList,将对应题目所选的答案与正确答案做对比
        for(Question question : questionList){
            //获取当前问题的id
            Integer id = question.getId();
            //获取当前题目所选择的答案
            String selection = request.getParameter(String.valueOf(id));

            //如果没有选择答案，则当前题目不计算分数
            if(selection == null || "".equals(selection)){
                score += 0;
            }else if(selection.equals(question.getAnswer())){
                //对比所选择的答案和正确答案，计算得分
                score += 40;
            }

        }

        //3.将结果返回至前端
        response.setCharacterEncoding("GBK");
        response.getWriter().write("您当前的分数为:" + score + "分");
    }
}
