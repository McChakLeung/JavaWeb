package com.dgpalife.service.impl;

import com.dgpalife.dao.TUserDao;
import com.dgpalife.dao.impl.TUserDaoImpl;
import com.dgpalife.model.User;
import com.dgpalife.service.UserService;
import com.dgpalife.util.PageBean;

import java.util.List;

public class UserServiceImpl implements UserService {

    private TUserDao userDao = new TUserDaoImpl();

    @Override
    public PageBean<User> findUserListWithPage(Integer pageNum, Integer pageSize) {
        //1.计算总记录数totalRecord
        Integer totalRecord = userDao.getTotalRecord();

        //2.创建PageBean对象
        PageBean<User> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);

        //3.获取pageBean对象的startLine
        Integer startLine = pageBean.getStartLine();

        //4.通过da返回分页数据
        List<User> userList = userDao.findUserListWithPage(startLine,pageSize);

        //5.将分页数据封装在pageBean内
        pageBean.setDataList(userList);

        //6.返回pageBean
        return pageBean;
    }

    @Override
    public Integer deleteUser(String[] params) {
        return userDao.deleteUser(params);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User findUserByID(Integer id) {
        return userDao.findUserByID(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username,password);
    }
}
