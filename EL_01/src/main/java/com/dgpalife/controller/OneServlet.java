package com.dgpalife.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();
        application.setAttribute("key1","maizeliang098");
        HttpSession session = req.getSession();
        session.setAttribute("key2","33岁");
        req.setAttribute("key3","dongguan");
        resp.setContentType("text/html;charset=utf-8");
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
