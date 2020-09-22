package com.dgpalife.dao;

import com.dgpalife.model.User;

import java.util.List;

public interface TUserDao {

    void addUser(User user);

    List<User> findUserList(String pageNum);

    Integer deleteUserByBatch(String[] params);

    User findUserByID(String id);

    void updateUser(User user);

    Integer countTotalPage();
}
