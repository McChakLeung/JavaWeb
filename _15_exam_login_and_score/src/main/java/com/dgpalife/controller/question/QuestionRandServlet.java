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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.从request中获取session
        HttpSession session = request.getSession(false);

        //2.从数据库中查询随机的题目
        List<Question> questionList = questionService.findRandQuestionList();

        //4.将查询的题目存放在session域中
        session.setAttribute("questionList",questionList);

        //5.请求转发至jsp页面
        request.getRequestDispatcher("/user/exam.jsp").forward(request,response);
    }
}
