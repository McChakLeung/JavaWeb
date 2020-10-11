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
        //1.查询所有的数据
        Integer totalLine = userDao.countTotalLine();

        //2.创建一个pageBean
        PageBean<User> pageBean = new PageBean<>(pageNum,pageSize,totalLine);

        //3.获取查询的startLine
        Integer startLine = pageBean.getStartLine();

        //4.将每页显示的数据查询出来
        List<User> userList = userDao.findUserListWithPage(startLine,pageSize);

        //5.将查询的数据放置在pagebean中并一并返回
        pageBean.setDataList(userList);

        return pageBean;
    }
}
