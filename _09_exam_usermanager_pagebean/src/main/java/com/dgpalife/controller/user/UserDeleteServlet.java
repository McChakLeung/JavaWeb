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
        //1.从异步请求对象中获取传入的参数数组
        String[] params = req.getParameterValues("id");

        //2.通过service层将数据进行删除
        Integer result = userService.deleteUserByBatch(params);

        //3.将处理结果写入到【响应体】
        resp.getWriter().print(result);
    }
}
