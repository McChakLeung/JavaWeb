package com.dgpalife.service.impl;

import com.dgpalife.dao.TUserDao;
import com.dgpalife.dao.impl.TUserDaoImpl;
import com.dgpalife.model.User;
import com.dgpalife.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private TUserDao tUserDao = new TUserDaoImpl();

    @Override
    public void addUser(User user) {
        tUserDao.addUser(user);
    }

    @Override
    public List<User> findUser() {
        List<User> userList = tUserDao.findUser();
        return userList;
    }

    @Override
    public void deleteUserByBatch(String[] param) {
        tUserDao.deleteUserByBatch(param);
    }
}
