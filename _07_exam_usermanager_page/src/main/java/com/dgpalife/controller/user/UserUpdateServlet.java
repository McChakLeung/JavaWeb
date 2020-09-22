package com.dgpalife.controller.user;

import com.dgpalife.model.User;
import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取request传入的数据
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        User user = new User(Integer.valueOf(id),username,pwd,email,telephone,null);

        //2.通过service层更新数据库数据
        userService.updateUser(user);

        //3.重定向至查询页面
        resp.sendRedirect("/exam/usermanager/find.do");
    }
}
