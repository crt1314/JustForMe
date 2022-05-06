package com.chrt.service;

import com.chrt.pojo.User;

public interface UserService {

    User findByUsername(User user);

    User findByUnAndPwd(User user);

    void addUser(User user);

    User findById(Integer id);
}
