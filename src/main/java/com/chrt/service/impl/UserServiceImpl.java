package com.chrt.service.impl;

import com.chrt.mapper.UserMapper;
import com.chrt.pojo.User;
import com.chrt.repository.UserRepository;
import com.chrt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(User user) {
        return findByUn(user.getUsername());
    }

    @Override
    public User findByUnAndPwd(User user) {
        return userMapper.findByUnAndPwd(user);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        }
        return user;
    }

    @Override
    public User findByUn(String username) {
        return userMapper.findByUsername(username);
    }
}
