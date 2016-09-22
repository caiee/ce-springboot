package com.ce.springboot.mapper;


import com.ce.springboot.entity.User;

import java.util.List;

public interface UserMapper {

    Integer insertUser(User user);

    User findUserById(Integer id);

    List<User> selectUsers();

    void update(User user);

    void delete(Integer id);
}