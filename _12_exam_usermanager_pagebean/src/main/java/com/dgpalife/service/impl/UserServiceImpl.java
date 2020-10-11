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
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> findUserList() {
        return userDao.findUserList();
    }

    @Override
    public Integer deleteUserByBatch(String[] params) {
        return userDao.deleteUserByBatch(params);
    }

    @Override
    public User findUserByID(String id) {
        return userDao.findUserByID(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public PageBean<User> findUserListWithPage(Integer pageNum, Integer pageSize) {

        //1.通过dao方法，查询数据库中的总记录数
        Integer totalRecord = userDao.countTotalRecord();

        //2.创建PageBean对象，并初始化
        PageBean<User> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);

        //3.从pageBean中获取startLine
        Integer startLine = pageBean.getStartLine();

        //4.通过dao方法，查询分页数据
        List<User> userList = userDao.findUserListWithPage(startLine,pageSize);

        //5.将查询的分页数据存放在pageBean对象中
        pageBean.setDataList(userList);

        //6.返回pageBean对象到
        return pageBean;
    }
}
