package com.dgpalife.controller;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取request对象中的参数
        String id = req.getParameter("id");

        //2.通过JDBC调用删除方法
        TQuestionDao tQuestionDao = new TQuestionDaoImpl();
        tQuestionDao.deleteQuestion(id);

        //3.重定向至查询页面
        resp.sendRedirect("/exam/question/find.do");

    }
}
