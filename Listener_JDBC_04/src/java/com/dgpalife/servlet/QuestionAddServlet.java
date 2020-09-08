package com.dgpalife.servlet;

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
        Question question = new Question();
        question.setTitle(req.getParameter("title"));
        question.setOptionA(req.getParameter("optionA"));
        question.setOptionB(req.getParameter("optionB"));
        question.setOptionC(req.getParameter("optionC"));
        question.setOptionD(req.getParameter("optionD"));
        question.setAnswer(req.getParameter("answer"));
        TQuestionDao tQuestionDao = new TQuestionDaoImpl();
        tQuestionDao.addQuestion(question,req);
        resp.sendRedirect("/find.do");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
