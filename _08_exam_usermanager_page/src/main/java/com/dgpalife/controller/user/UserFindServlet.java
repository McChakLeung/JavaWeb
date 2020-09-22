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
        //1.从前端获取传入的当前页数据
        String pageNum = req.getParameter("pageNum");

        //2.判断该参数是否为空，如果为空，则设置为默认1
        if(pageNum == null || "".equals(pageNum)){
            pageNum = "1";
        }

        //3.通过service层将数据查询出分页数据
        List<User> userList = userService.findUserList(pageNum);

        //4.通过调用service层，查询总页数
        Integer totalPage = userService.countTotalPage();

        //4.将查询的数据放入到request中
        req.setAttribute("userList",userList);

        //5.将pageNum重新传回页面
        req.setAttribute("pageNum",pageNum);

        //6.将totalpage传回页面
        req.setAttribute("totalPage",totalPage);

        //3.请求转发至查询页面
        req.getRequestDispatcher("/usermanager/user.jsp").forward(req,resp);

    }
}
