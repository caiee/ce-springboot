package com.ce.springboot.controller;


import com.ce.springboot.config.InjectPropertiesField;
import com.ce.springboot.config.InjectYmlField;
import com.ce.springboot.config.SuccessEntity;
import com.ce.springboot.entity.InvalidArgumentException;
import com.ce.springboot.entity.User;
import com.ce.springboot.service.UserService;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author caie
 * @since 16/9/1
 */
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private InjectYmlField injectField;

    @Autowired
    private InjectPropertiesField injectPropertiesField;

    @GetMapping("a")
    public User insert() {
        User user = new User();
        user.setName("user name");
        user.setAge(20);
        user.setAddress("user address");
        user.setEmail("user email");
        user.setPhone("user phone");

        userService.insert(user);
        return user;
    }

    @GetMapping("b")
    public List<User> find() {
        List<User> users = userService.find();
        return users;
    }

    @PostMapping("c")
    public SuccessEntity update(User user) {
        userService.update(user);

        SuccessEntity successEntity = new SuccessEntity();
        successEntity.setMessage("更新成功");
        successEntity.setData("hehe");
        return successEntity;
    }

    @GetMapping("d/{id}")
    public User getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

    @DeleteMapping("e/{id}")
    public SuccessEntity delete(@PathVariable Integer id) {
        userService.delete(id);

        SuccessEntity successEntity = new SuccessEntity();
        successEntity.setMessage("更新成功");
        successEntity.setData("hehe");
        return successEntity;
    }


    @GetMapping("f")
    public User testException(String name) throws InvalidArgumentException {
        throw new InvalidArgumentException("测试异常中.");
    }


    @GetMapping("x")
    public Object getString() {

        // 配置文件注入 YML 语法
        final Integer age = injectField.getAge();
        final String name = injectField.getName();
        final Double score = injectField.getScore();

        // 配置文件注入 Properties 语法
        final String pay_url = injectPropertiesField.getPAY_URL();

        return ImmutableMap.of("key", name + " \n " + pay_url);
    }

}
