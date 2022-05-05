package com.chrt.service;

import com.chrt.pojo.User;

public interface UserService {

    User findByUsername(User user);

    User findByUnAndPwd(User user);

    void addUser(User user);

    Integer findIdByUsername(User user);

    User findById(Integer id);

    void updatePassword(String username, String newPassword);

    void updateUsername(String oldName, String newName);

    User findByUsername(String username);
}
