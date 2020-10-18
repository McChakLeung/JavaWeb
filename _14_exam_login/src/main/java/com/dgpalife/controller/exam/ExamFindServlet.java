package com.dgpalife.controller.exam;

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

public class ExamFindServlet extends HttpServlet {

    private QuestionService questionService = new QuestionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从req对象中获取session
        HttpSession session = req.getSession(false);

        //2.从数据库中随机查出10道题
        List<Question> questionList = questionService.findQuestionList();

        //3.将查询的数据存放在session域中
        session.setAttribute("questionList",questionList);

        //4.请求转发至jsp页面
        req.getRequestDispatcher("/user/exam.jsp").forward(req,resp);
    }
}
