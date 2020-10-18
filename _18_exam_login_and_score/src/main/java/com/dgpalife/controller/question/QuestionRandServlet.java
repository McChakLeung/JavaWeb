package com.dgpalife.controller.question;

import com.dgpalife.model.Question;
import com.dgpalife.service.QuestionService;
import com.dgpalife.service.impl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {

    private QuestionService questionService = new QuestionServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session,false的意思是如果当前用户没有session，不会创造新的session给用户
        HttpSession session = request.getSession(false);

        //2.向数据库获取随机的题目
        List<Question> questionList = questionService.findRandomQuestionList();

        //3.将题目存放到session域中
        session.setAttribute("questionList",questionList);

        //4.请求转发至jsp页面
        request.getRequestDispatcher("/user/exam.jsp").forward(request,response);
    }
}
