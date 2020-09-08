package com.dgpalife.servlet;

import com.dgpalife.dao.TEmpDao;
import com.dgpalife.dao.impl.TEmpDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession(false);
        TEmpDao tEmpDao = new TEmpDaoImpl();
        int flag = tEmpDao.checkAccount(username,password);
        if(flag<1){
            resp.setContentType("text/html;charset-utf8");
            resp.getWriter().write(username + "error");
        }else{
            session.setAttribute("username",username);
            resp.sendRedirect("/index.do");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
