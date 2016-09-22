package com.ce.springboot.service;

import com.ce.springboot.entity.User;
import com.ce.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caie
 * @since 16/9/1
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public List<User> find() {
        return userMapper.selectUsers();
    }

    @Override
    public User getUserById(Integer userId) {
        User user = new User();
        user.setId(userId);
        user.setName("user name");
        user.setAge(20);
        user.setAddress("user address");
        user.setEmail("user email");
        user.setPhone("user phone");
        return user;
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

}
