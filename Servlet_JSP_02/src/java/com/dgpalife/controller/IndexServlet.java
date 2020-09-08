package com.dgpalife.controller;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionImpl;
import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TQuestionDao tQuestionDao = new TQuestionImpl();
        List<Question> questionList =  tQuestionDao.findQuestionList();
        req.setAttribute("questionList",questionList);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
