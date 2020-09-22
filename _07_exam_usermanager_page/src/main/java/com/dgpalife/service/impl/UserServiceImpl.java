package com.dgpalife.service.impl;

import com.dgpalife.dao.TUserDao;
import com.dgpalife.dao.impl.TUserDaoImpl;
import com.dgpalife.model.User;
import com.dgpalife.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private TUserDao userDao = new TUserDaoImpl();

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> findUser(String pageNum) {
        return userDao.findUser(pageNum);
    }

    @Override
    public void deleteUser(String[] params) {
        userDao.deleteUser(params);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public Integer countTotalPage() {
        return userDao.countTotalPage();
    }
}
