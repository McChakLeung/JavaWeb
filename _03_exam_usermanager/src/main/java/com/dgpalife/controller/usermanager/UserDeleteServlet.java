package com.dgpalife.controller.usermanager;

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
        //1.从前端获取传入的参数
        String[] params = req.getParameterValues("id");

        //2.通过service层批量删除
        Integer flag = userService.deleteUser(params);

        //3.返回前端数据给Ajax
        resp.getWriter().print(flag);

    }
}
