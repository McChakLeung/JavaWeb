package com.dgpalife.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //this.doGet(request,response);
        String servletPath = request.getServletPath();
        String contextPath = request.getContextPath();
        String pathInfo = request.getPathInfo();
        String requestURL = request.getRequestURI();
        //在获取响应流之前设置contentType,否则获取了响应流再设置contentType后会不起作用
        response.setContentType("text/html;charset=UTF-8");
        //获取响应流PrintWriter
        PrintWriter out = response.getWriter();
        out.println("第一servletPath:"+servletPath);
        out.print("contextPath:"+contextPath);
        out.print("pathInfo:"+pathInfo);
        out.write("requestURL:"+requestURL);

    }
}
