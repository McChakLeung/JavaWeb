package com.dgpalife.controller.usermanager;

import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet{

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从前端获取数据
        String[] param = req.getParameterValues("id");

        //2.通过service方法，将数据插入到数据库中
        userService.deleteUserByBatch(param);

        //3.重定向至查询页面
        resp.sendRedirect("/exam/usermanager/find.do");
    }
}
