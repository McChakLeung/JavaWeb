package com.dgpalife.controller.user;

import com.dgpalife.model.User;
import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;
import com.dgpalife.util.PageBean;

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

        //1.获取从客户端传入的参数，并判断是否为0
        Integer pageNum = Integer.valueOf(req.getParameter("pageNum"));

        if(pageNum == 0){
            pageNum = 1;
        }

        //2.设置pageSize
        Integer pageSize = 10;

        //3.通过service方法处理查询
        PageBean<User> pageBean = userService.findUserListWithPage(pageNum,pageSize);

        //4.将查询的数据放入到request中
        req.setAttribute("pageBean",pageBean);

        //5.请求转发至查询页面
        req.getRequestDispatcher("/usermanager/user.jsp").forward(req,resp);

    }
}
