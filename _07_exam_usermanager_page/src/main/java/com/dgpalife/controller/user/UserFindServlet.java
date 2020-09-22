package com.dgpalife.controller.user;

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
        //0.从前端获取传入的参数
        String pageNum = req.getParameter("pageNum");

        //判断传入的pageNum是否为空
        if(pageNum == null || "".equals(pageNum)){
            pageNum = "1";
        }

        //1.通过service层将数据查询出来
        List<User> userList = userService.findUser(pageNum);

        Integer totalPage = userService.countTotalPage();

        //2.将查询的数据放入到request中
        req.setAttribute("userList",userList);

        //3.将当前页传回给页面
        req.setAttribute("pageNum",pageNum);

        //4.将总页数传回给页面
        req.setAttribute("totalPage",totalPage);

        //3.请求转发至查询页面
        req.getRequestDispatcher("/usermanager/user.jsp").forward(req,resp);

    }
}
