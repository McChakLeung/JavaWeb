package com.dgpalife.servlet;

import com.dgpalife.dao.TQuestionDao;
import com.dgpalife.dao.impl.TQuestionDaoImpl;
import com.dgpalife.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //ServletContext application = req.getServletContext();
        TQuestionDao tQuestionDao = new TQuestionDaoImpl();
        List<Question> questionList =  tQuestionDao.findQuestion(req);
        req.setAttribute("questionList",questionList);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
