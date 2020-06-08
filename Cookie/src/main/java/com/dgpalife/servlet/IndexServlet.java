package com.dgpalife.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class IndexServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        String username = null;
        if(session!=null){
            username = (String)session.getAttribute("username");
        }
        resp.getWriter().write("欢迎"+username+"登录");
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            resp.getWriter().write("welcome " + cookie.getName() + " to Login!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
