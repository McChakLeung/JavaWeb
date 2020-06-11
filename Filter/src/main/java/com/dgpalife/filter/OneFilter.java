package com.dgpalife.filter;

import javax.servlet.*;
import java.io.IOException;

public class OneFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String age =  servletRequest.getParameter("age");
        Integer a = null;
        if(age!=null){
            a = Integer.valueOf(age);
        }

        if(a>=70){
            servletResponse.setCharacterEncoding("GBK");
            servletResponse.getWriter().write("大爷，您年纪大了，注意身体啊");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
