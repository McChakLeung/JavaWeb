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
        //1.通过service层将数据查询出来
        Integer pageNum = Integer.valueOf(req.getParameter("pageNum"));

        //2.判断pageNum是否为0
        if(pageNum == 0){
            pageNum = 1;
        }

        //3.设定PageSize
        Integer pageSize = 10;

        //3.调用service方法
        PageBean<User> pageBean = userService.findUserListWithPage(pageNum,pageSize);

        //2.将查询的数据放入到request中
        req.setAttribute("pageBean",pageBean);

        //3.请求转发至查询页面
        req.getRequestDispatcher("/usermanager/user.jsp").forward(req,resp);

    }
}
