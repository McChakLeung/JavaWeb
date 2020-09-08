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

public class QuestionFindServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.从数据库中查询出相关数据
        TQuestionDao questionDao = new TQuestionDaoImpl();
        List<Question> questionList = questionDao.findQuestion();

        //2.将数据存放在request对象中
        req.setAttribute("questionList",questionList);

        //3.请求转发至jsp页面
        req.getRequestDispatcher("/exammanager/exams.jsp").forward(req,resp);
    }
}
