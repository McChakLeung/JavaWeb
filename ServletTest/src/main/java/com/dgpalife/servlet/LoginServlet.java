package com.dgpalife.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前servlet的servletconfig对象
        //response.getWriter().write("Login");
        ServletConfig servletConfig = this.getServletConfig();
        String name = servletConfig.getServletName();
        //Enumeration<String> names = servletConfig.getInitParameterNames();
        //String value =servletConfig.getInitParameter(name);
        ServletContext application = servletConfig.getServletContext();
        response.getWriter().write(name);
        response.getWriter().write("\n");
        //response.getWriter().write(names.toString());
        response.getWriter().write("\n");
        //response.getWriter().write(value);

        response.getWriter().write(application.toString());
        //application.setAttribute("key","hello world");
        response.getWriter().write("\n");
        response.getWriter().write((String)application.getAttribute("key"));
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//        resp.getWriter().write("\n");
//        resp.getWriter().write("service:Login");
//    }
}
