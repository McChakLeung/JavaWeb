package com.dgpalife.controller.question;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionDaoImpl;
import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从request对象中获取相关参数
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String optionA = req.getParameter("optionA");
        String optionB = req.getParameter("optionB");
        String optionC = req.getParameter("optionC");
        String optionD = req.getParameter("optionD");
        String answer = req.getParameter("answer");
        Question question = new Question(Integer.valueOf(id),title,optionA,optionB,optionC,optionD,answer);

        //2.通过jdbc更新传入的数据
        TQuestionDao questionDao = new TQuestionDaoImpl();
        questionDao.updateQuestion(question);

        //3.重定向至查询页面
        resp.sendRedirect("/exam/question/find.do");

    }
}
