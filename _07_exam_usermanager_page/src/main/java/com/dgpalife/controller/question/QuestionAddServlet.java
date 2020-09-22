package com.dgpalife.controller.question;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionDaoImpl;
import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取从request中获取的参数
        String title = req.getParameter("title");
        String optionA = req.getParameter("optionA");
        String optionB = req.getParameter("optionB");
        String optionC = req.getParameter("optionC");
        String optionD = req.getParameter("optionD");
        String answer = req.getParameter("answer");
        Question question = new Question(title,optionA,optionB,optionC,optionD,answer);

        //2.通过jdbc将数据插入到数据库中
        TQuestionDao questionDao = new TQuestionDaoImpl();
        questionDao.addQuestion(question);

        //3.重定向至查询页面
        resp.sendRedirect("/exam/question/find.do");
    }
}
