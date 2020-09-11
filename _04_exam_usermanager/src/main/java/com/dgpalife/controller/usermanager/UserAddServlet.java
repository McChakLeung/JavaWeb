package com.dgpalife.controller.usermanager;

import com.dgpalife.model.User;
import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAddServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取request对象中传入的参数
        String username = req.getParameter("username");
        String pwd  = req.getParameter("pwd");
        String email  = req.getParameter("email");
        String telephone  = req.getParameter("telephone");
        User user = new User(username,pwd,email,telephone);

        //2.通过service层将数据插入到数据库中
        userService.addUser(user);

        //3.重定向至查询页面中
        resp.sendRedirect("/exam/usermanager/find.do");
    }
}
