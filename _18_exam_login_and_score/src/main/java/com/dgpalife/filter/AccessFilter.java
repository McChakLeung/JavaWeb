package com.dgpalife.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.将ServletRequest和ServletResponse转换成HttpServletRequest和HttpServletResponse
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2.设置可放行的访问路径和静态资源文件类型，并判断当前RequestURI是否可以在可放行的集合中
        String[] urls = {"/login","/json",".ico",".css",".js",".jpg",".png"};
        String uri = request.getRequestURI();
        for(String url : urls){
            if(uri.contains(url)){
                chain.doFilter(req,resp);
                return; //必须要加return,否则即使路径在集合中，也会导致其他资源文件被拦截
            }
        }

        //3.获取session，判断session是否为空，如果为空，则重定向至登录页面；如果不为空，则放行
        HttpSession session = request.getSession(false);
        if(session!=null){
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect("/login.html");
        }
    }


}
