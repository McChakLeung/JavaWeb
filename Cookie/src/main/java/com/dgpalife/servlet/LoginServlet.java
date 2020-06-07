package com.dgpalife.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String autoLogin = req.getParameter("autoLogin");
        if("maizeliang098".equals(username) && "123456".equals(password)){
            if("on".equals(autoLogin)){
                Cookie cookie = new Cookie(username,password);
                cookie.setMaxAge(3600);
                resp.addCookie(cookie);
            }
            resp.sendRedirect("/index.do");
        }else {
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
