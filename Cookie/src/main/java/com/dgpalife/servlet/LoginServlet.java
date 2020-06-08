package com.dgpalife.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String autoLogin = req.getParameter("autoLogin");
        if("maizeliang098".equals(username) && "123456".equals(password)){
            if(session!=null){
                session.setAttribute("username",username);
            }
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
