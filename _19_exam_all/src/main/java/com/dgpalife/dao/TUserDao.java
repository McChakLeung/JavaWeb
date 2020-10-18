package com.dgpalife.dao;

import com.dgpalife.model.User;

import java.util.List;

public interface TUserDao {

    Integer getTotalRecord();

    List<User> findUserListWithPage(Integer startLine, Integer pageSize);

    Integer deleteUser(String[] params);

    void addUser(User user);

    User findUserByID(Integer id);

    void updateUser(User user);
}
