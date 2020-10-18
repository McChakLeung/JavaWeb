package com.dgpalife.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AccessFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //1.从request中获取Session
        HttpSession session = request.getSession(false);

        //2.获取当前的路径
        String uri = request.getRequestURI();

        //3.判断当前路径是否为login的页面
        if(uri.indexOf("/login")!= -1){
            chain.doFilter(req, resp);
            return;
        }

        //2.判断session是否存在
        //如果不存在，退回至login.html
        if(session == null){
            response.sendRedirect("/login.html");
        }else{
            //3.如果存在，跳转至index.html
            chain.doFilter(req, resp);
        }
    }


}
