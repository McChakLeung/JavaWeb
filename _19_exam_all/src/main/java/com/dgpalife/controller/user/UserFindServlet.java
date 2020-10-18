package com.dgpalife.controller.user;

import com.dgpalife.model.User;
import com.dgpalife.service.UserService;
import com.dgpalife.service.impl.UserServiceImpl;
import com.dgpalife.util.PageBean;
import org.omg.CORBA.INTERNAL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFindServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.从客户端获取pageNum，并设置初始值
        String pageNum = req.getParameter("pageNum");

        if(pageNum == null || "".equals(pageNum)){
            pageNum = "1";
        }

        //2.设置pageSize
        Integer pageSize = 10;

        //3.通过service方法查询分页数据
        PageBean<User> pageBean = userService.findUserListWithPage(Integer.valueOf(pageNum),pageSize);

        //4.将查询的数据放在request对象中
        req.setAttribute("pageBean",pageBean);

        //5.请求转发至jsp页面
        req.getRequestDispatcher("/usermanager/users.jsp").forward(req,resp);

    }
}
