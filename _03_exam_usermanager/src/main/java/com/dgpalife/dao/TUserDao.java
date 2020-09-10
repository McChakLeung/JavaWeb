package com.dgpalife.dao;

import com.dgpalife.model.User;

import java.util.List;

public interface TUserDao {

    void addUser(User user);

    List<User> findUser();

    Integer deleteUser(String[] params);
}
