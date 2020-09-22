package com.dgpalife.service;

import com.dgpalife.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> findUser();

    void deleteUserByBatch(String[] param);
}
