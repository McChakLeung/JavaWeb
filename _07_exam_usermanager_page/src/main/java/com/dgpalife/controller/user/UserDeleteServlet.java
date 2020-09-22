package com.dgpalife.controller.user;

import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取request中传入的数据
        String[] params = req.getParameterValues("id");

        //2.通过service层删除数据
        userService.deleteUser(params);

        //3.重定向至查询页面
        resp.sendRedirect("/exam/usermanager/find.do");
    }
}
