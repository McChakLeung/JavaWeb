package com.dgpalife.controller.usermanager;

import com.dgpalife.model.User;
import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserFindServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从service层中查询数据库数据
        List<User> userList = userService.findUser();

        //2.将数据库的数据存放在request对象中
        req.setAttribute("userList",userList);

        //3.请求转发至jsp页面
        req.getRequestDispatcher("/usermanager/user.jsp").forward(req,resp);
    }
}
