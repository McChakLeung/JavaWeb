package com.dgpalife.service;

import com.dgpalife.model.User;
import com.dgpalife.util.PageBean;

public interface UserService {
    PageBean<User> findUserListWithPage(Integer pageNum, Integer pageSize);

    Integer deleteUser(String[] params);

    void addUser(User user);

    User findUserByID(Integer id);

    void updateUser(User user);
}
