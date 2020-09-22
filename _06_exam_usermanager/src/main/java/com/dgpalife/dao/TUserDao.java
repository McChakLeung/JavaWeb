package com.dgpalife.dao;

import com.dgpalife.model.User;

import java.util.List;

public interface TUserDao {

    void addUser(User user);

    List<User> findUser();

    void deleteUser(String[] params);

    User findUserById(String id);

    void updateUser(User user);
}
