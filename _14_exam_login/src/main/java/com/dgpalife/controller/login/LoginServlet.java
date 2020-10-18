package com.dgpalife.controller.login;

import com.dgpalife.model.User;
import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet{

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从前端获取传入的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.查询数据库中所存在的用户
        User user = userService.checkUser(username,password);


        //3.通过查询后，判断数据是否为空，如果为空，说明该账号不存在，跳回登录页面
        // 如果不为空，则将数据存放在session中，并跳转至首页
        if(user==null){
            resp.sendRedirect("/login.html");
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("/index.html");
        }
    }
}
