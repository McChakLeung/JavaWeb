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
    public PageBean<User> findAllUserWithPage(Integer pageNum, Integer pageSize) {
        //在这里就要将PageBean中的数据创建好，然后将该对象传回去
        //先要从数据库中获取所有用户的数据量有多少，获得totalRecord
        //List<User> userList = userDao.findUserList();
        Integer totalRecord = userDao.countTotalRecord();

        //有了三个初始数据，就能创建pageBean对象
        PageBean pageBean = new PageBean(pageNum,pageSize,totalRecord);

        //获取PageBean对象中的StartLine
        Integer startLine = pageBean.getStartLine();

        //有startLine和pageSize，就可以拿到每页的数据
        pageBean.setDataList(userDao.findUserListWithPage(startLine,pageSize));

        return pageBean;
    }
}
