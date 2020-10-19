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

        //1.将ServletRequest和ServletResponse接口转换为HttpServletRequest和HttpServletResponse接口
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2.获取当前访问的请求地址
        String uri = request.getRequestURI();

        //3.设允许访问的请求和静态资源文件类型
        String[] urls = {"/login","/json","ico",".js",".css",".jpg",".png"};

        //4.判断当前访问的地址是否包含在所设置的可允许访问的请求和静态资源文件类型
        //如果包含，则放行
        for(String url : urls){
            if(uri.contains(url)){
                chain.doFilter(request,response);
                return;
            }
        }

        //5.获取当前请求的session
        HttpSession session = request.getSession(false);

        //6.判断session是否为空，如果不为空，则放行；如果为空，则跳转至登录页面
        if(session!=null){
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect("/login.html");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
