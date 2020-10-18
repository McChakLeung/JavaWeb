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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从request中获取username和password
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.通过数据库查询是否存在当前用户，
        User user = userService.findUserByUsernameAndPassword(username,password);

        //3.如果存在，则存放在session中；
        if(user!=null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("/index.html");
        }

        //4.如果不存在，则跳转回登录页面
        if(user == null){
            resp.sendRedirect("/login.html");
        }

    }
}
