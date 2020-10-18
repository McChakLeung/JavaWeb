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

        //1.从客户端获取返回的数据
        String[] params = req.getParameterValues("id");

        //2.通过service方法删除对应的数据
        Integer result = userService.deleteUser(params);

        //3.返回结果
        resp.getWriter().write(result);
    }
}
