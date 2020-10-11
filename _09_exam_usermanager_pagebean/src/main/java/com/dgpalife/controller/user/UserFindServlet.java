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

        //1.从前端获取当前页pageNum
        int pageNum = Integer.valueOf(req.getParameter("pageNum"));

        if(pageNum <= 0){
            pageNum = 1;
        }

        //2.设置每页显示记录数
        int pageSize = 10;

        //1.通过service层将数据查询出来
        //List<User> userList = userService.findUserList();

        //3.获取一个Pageean对象，pageBean包含了所有分页所需要的数据
        PageBean<User> pageBean = userService.findAllUserWithPage(pageNum,pageSize);

        //2.将查询的数据放入到request中
        req.setAttribute("pageBean",pageBean);

        //3.请求转发至查询页面
        req.getRequestDispatcher("/usermanager/user.jsp").forward(req,resp);

    }
}
