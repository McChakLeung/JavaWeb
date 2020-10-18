package com.dgpalife.controller.question;

import com.dgpalife.model.Question;
import com.dgpalife.service.QuestionService;
import com.dgpalife.service.impl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindByIDServlet extends HttpServlet{

    private QuestionService questionService = new QuestionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取前端传入的数据
        Integer id = Integer.valueOf(req.getParameter("id"));

        //2.通过service方法查询数据库数据
        Question question = questionService.findQuestionByID(id);

        //3.将查询的结果放置在request对象中
        req.setAttribute("question",question);

        //4.请求转发至jsp页面
        req.getRequestDispatcher("/exammanager/examEdit.jsp").forward(req,resp);
    }
}
