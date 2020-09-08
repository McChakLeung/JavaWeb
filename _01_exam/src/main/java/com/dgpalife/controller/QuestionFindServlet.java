package com.dgpalife.controller;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionDaoImpl;
import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从jdbc中查询所有数据
        TQuestionDao tQuestionDao = new TQuestionDaoImpl();
        List<Question> questionList = tQuestionDao.findQuestionList();

        //2.将查询的数据存放在request中
        req.setAttribute("questionList",questionList);

        //3.请求转发到jsp页面，向用户展示数据
        req.getRequestDispatcher("/exammanager/exams.jsp").forward(req,resp);

    }
}
