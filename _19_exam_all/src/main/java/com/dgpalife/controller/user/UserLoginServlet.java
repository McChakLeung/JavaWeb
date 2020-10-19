package com.dgpalife.controller.user;

import com.dgpalife.model.User;
import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.从客户端获取传入的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.通过service方法查询该用户是否存在
        User user = userService.findUserByUsernameAndPassword(username,password);

        //3.如果该用户不为空，则分配session，如果为空，则跳转至登录页面
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("/index.html");
        }else{
            response.sendRedirect("/login.html");
        }
    }
}
