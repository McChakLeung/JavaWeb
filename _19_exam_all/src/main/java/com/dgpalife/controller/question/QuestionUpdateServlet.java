package com.dgpalife.controller.question;

import com.dgpalife.model.Question;
import com.dgpalife.service.QuestionService;
import com.dgpalife.service.impl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {

    private QuestionService questionService = new QuestionServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从前端获取传入的数据
        Integer id = Integer.valueOf(req.getParameter("id"));
        String title = req.getParameter("title");
        String optionA = req.getParameter("optionA");
        String optionB = req.getParameter("optionB");
        String optionC = req.getParameter("optionC");
        String optionD = req.getParameter("optionD");
        String answer = req.getParameter("answer");
        Question question = new Question(id,title,optionA,optionB,optionC,optionD,answer);

        //2.通过service方法更新数据库数据
        questionService.updateQuestion(question);

        //3.重定向至查询页面
        resp.sendRedirect("/exam/question/find.do");
    }
}
