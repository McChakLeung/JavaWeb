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
        //1.从客户端获取传入的参数
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        User user = new User(Integer.valueOf(id),username,password,email,telephone,null);

        //2.通过service方法，更新数据库数据
        userService.updateUser(user);

        //3.重定向至查询页面
        resp.sendRedirect("/exam/user/find.do");
    }
}
