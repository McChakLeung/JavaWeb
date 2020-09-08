package com.dgpalife.controller;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionImpl;
import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Question question = new Question();
        question.setTitle(req.getParameter("title"));
        question.setOptionA(req.getParameter("optionA"));
        question.setOptionB(req.getParameter("optionB"));
        question.setOptionC(req.getParameter("optionC"));
        question.setOptionD(req.getParameter("optionD"));
        question.setAnswer(req.getParameter("answer"));
        TQuestionDao tQuestionDao = new TQuestionImpl();
        tQuestionDao.addQuestion(question);
        //不适合不适合添加/删除/更新Servlet调用查询功能Servlet使用请求转发：
        //请求转发发生在服务端的，所以浏览器地址栏内容是保持
        //第一次请求的内容，此时用户如果点击【刷新按钮】
        //导致浏览器向服务端发送重复【数据修改】操作
        //因此服务端运行失败
        //req.getRequestDispatcher("/index.do").forward(req,resp);
        resp.sendRedirect("/index.do");
    }
}
