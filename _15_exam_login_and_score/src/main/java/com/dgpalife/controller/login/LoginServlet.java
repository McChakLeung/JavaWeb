package com.dgpalife.controller.login;

import com.dgpalife.model.User;
import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;
import com.sun.org.apache.xerces.internal.util.HTTPInputSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从前端获取登录账号和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.通过数据库查询输入的账号和密码查询用户信息
        User user = userService.findUserByUserNameAndPassword(username,password);

        //3.判断用户是否存在，如果存在的话就创建session，并跳转至index页面
        if(user!=null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("/index.html");
        }else{
            //4.如果不存在的话则跳转至login页面
            resp.sendRedirect("/login.html");
        }


    }
}
