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
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2.获取session对象和当前请求的uri地址
        HttpSession session = request.getSession(false);
        String uri = ((HttpServletRequest) req).getRequestURI();

        //3.定义可放行的地址和静态文件类型
        String[] urls = {"/login","/json",".css",".js",".jpg",".png",".icon"};

        //4.放行可访问的地址和静态资源类型
        for(String url : urls){
            if(uri.contains(url)){
                chain.doFilter(req,resp);
                return;
            }
        }

        //5.判断session对象是否为空，如果为空，则跳转至登录页面；否则放行
        if(session == null){
            response.sendRedirect("/login.html");
        }else{
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
