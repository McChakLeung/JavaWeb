package com.dgpalife.controller.user;

import com.dgpalife.model.User;
import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFindByIDServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.接收从客户端传入的参数
        String id = req.getParameter("id");

        //2.通过service方法查询数据
        User user = userService.findUserByID(Integer.valueOf(id));

        //3.将查询的数据存放在request对象中
        req.setAttribute("user",user);

        //4.请求转发至jsp页面
        req.getRequestDispatcher("/usermanager/userEdit.jsp").forward(req,resp);

    }
}
