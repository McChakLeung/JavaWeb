package com.dgpalife.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.将req和resp对象转换为HttpServletRequest和HttpServletResponse对象
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2.获取当前的uri，并定义可放行的访问路径和静态资源文件类型，判断是否可以放行
        String uri = request.getRequestURI();
        String[] urls = {"/login","/json",".ico",".js",".css",".jpg",".png"};
        for(String url : urls){
            if(uri.contains(url)){
                chain.doFilter(req,resp);
                return;  //必须要return,否则即使包含了字段，也会一直循环下去
            }
        }

        //3.获取session
        HttpSession session = request.getSession(false);

        //4.判断session是否为空，如果为空，则跳转至登录页面；若不为空，则放行
        if(session!= null){
            chain.doFilter(req, resp);
            return;
        }else{
            response.sendRedirect("/login.html");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
