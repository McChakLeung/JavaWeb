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
        //1.从前端获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.从数据库查询是否存在该用户
        User user = userService.findUserByUsernameAndPassword(username, password);

        //3.如果存在该用户，则存放在session
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("/index.html");
        }else{
            //4.如果不存在，则跳转至登录页面
            response.sendRedirect("/login.html");
        }


    }
}
