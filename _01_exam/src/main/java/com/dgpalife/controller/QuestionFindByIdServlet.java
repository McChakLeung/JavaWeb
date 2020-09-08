package com.dgpalife.controller;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionDaoImpl;
import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求对象的参数
        String id = req.getParameter("id");

        //2.通过JDBC查询相关数据
        TQuestionDao questionDao = new TQuestionDaoImpl();
        Question question = questionDao.findQuestionById(id);

        //3.将查询数据存放在request对象中
        req.setAttribute("question",question);

        //4.请求转发至jsp页面
        req.getRequestDispatcher("/exammanager/examEdit.jsp").forward(req,resp);

    }
}
