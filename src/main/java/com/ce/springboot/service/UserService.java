package com.ce.springboot.service;

import com.ce.springboot.entity.User;

import java.util.List;

/**
 * @author caie
 * @since 16/9/1
 */
public interface UserService {

    void insert(User user);

    List<User> find();

    User getUserById(Integer userId);

    void update(User user);

    void delete(Integer id);
}
