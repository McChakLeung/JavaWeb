package com.dgpalife.controller.question;

import com.dgpalife.service.QuestionService;
import com.dgpalife.service.impl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {

    private QuestionService questionService = new QuestionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从前端获取传入的参数
        Integer id = Integer.valueOf(req.getParameter("id"));

        //2.通过service方法将数据删除
        questionService.deleteQuestion(id);

        //3.重定向至find.do页面
        resp.sendRedirect("/exam/question/find.do");
    }
}
