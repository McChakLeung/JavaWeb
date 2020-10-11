package com.dgpalife.service;

import com.dgpalife.model.User;
import com.dgpalife.util.PageBean;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> findUserList();

    Integer deleteUserByBatch(String[] params);

    User findUserByID(String id);

    void updateUser(User user);

    PageBean<User> findAllUserWithPage(Integer pageNum, Integer pageSize);
}
