package com.dgpalife.controller;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionDaoImpl;
import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindByIdServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从request中获取参数
        String id = req.getParameter("id");

        //2.通过jdbc查询单个数据
        TQuestionDao questionDao = new TQuestionDaoImpl();
        Question question = questionDao.findById(id);

        //3.将数据存放在request对象中
        req.setAttribute("question",question);

        //4.请求转发至查询页面
        req.getRequestDispatcher("/exammanager/examEdit.jsp").forward(req,resp);

    }
}
