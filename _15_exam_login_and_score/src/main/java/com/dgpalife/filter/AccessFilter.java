package com.dgpalife.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换req和resp为HttpServletRequest和HttpServletResponse对象
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //1.从req中获取Session
        HttpSession session = request.getSession(false);

        //2.获取当前的访问路径是否包含了login的路径，如果包含，则放行
        String uri = request.getRequestURI();

        String[] urls = {"/login","/json",".js",".css",".jpg",".png",".ico"};

        for(String url:urls) {
            if (uri.indexOf(url) != -1) {
                chain.doFilter(req, resp);
                return;
            }
        }

        //3.判断session是否存在，如果存在，则放行；如果不存在，则跳转至登录页面
        if(session!=null){
            chain.doFilter(req, resp);
        }else{
            response.sendRedirect("/login.html");
        }

    }

}
