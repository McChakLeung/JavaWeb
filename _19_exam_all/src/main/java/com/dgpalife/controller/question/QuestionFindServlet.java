package com.dgpalife.controller.question;

import com.dgpalife.model.Question;
import com.dgpalife.service.QuestionService;
import com.dgpalife.service.impl.QuestionServiceImpl;
import com.dgpalife.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindServlet extends HttpServlet {

    private QuestionService questionService = new QuestionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取从前端传入的pageNum
        String pageNum = req.getParameter("pageNum");

        if(pageNum == null || "".equals(pageNum)){
            pageNum = "1";
        }

        //2.定义pageSize
        Integer pageSize = 5;

        //3.通过service方法向数据库查询数据
        PageBean<Question> pageBean = questionService.findQuestionListWithPage(Integer.valueOf(pageNum),pageSize);

        //4.将查询的数据存放在request对象中
        req.setAttribute("pageBean",pageBean);

        //5.请求转发至jsp页面
        req.getRequestDispatcher("/exammanager/exams.jsp").forward(req,resp);
    }
}
