package com.ce.springboot.dao;

import com.ce.springboot.ApplicationBaseTest;
import com.ce.springboot.entity.Page;
import com.ce.springboot.entity.User;
import com.ce.springboot.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author caie
 * @since 16/9/1
 */
public class UserMapperTestCaseTemplate extends ApplicationBaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        PageHelper.startPage(1, 10);
        final List<User> allUsers = userMapper.selectUsers();
        assertNotNull(allUsers);
        assertEquals(allUsers.size(), 10);
    }

    @Test
    public void testSelectPage() {
        PageHelper.startPage(2, 6);
        final List<User> allUsers = userMapper.selectUsers();
        final Page page = Page.toPage(allUsers);

        assertNotNull(allUsers);
        assertEquals(2, page.getCurrent());
        assertEquals(6, page.getPer());
        assertEquals(28, page.getCount());
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("test_transaction");
        user.setPhone("test-phone");
        user.setEmail("test-email");
        user.setAddress("test-address");
        user.setAge(20);

        Integer result = userMapper.insertUser(user);
        assertEquals(1, (int) result);
    }

    @Test
    public void testUpdate() {
        final String phone = "15397300863";
        User user = new User();
        user.setId(11);
        user.setPhone(phone);
        userMapper.update(user);

        final User userById = userMapper.findUserById(11);
        assertEquals(phone, userById.getPhone());
    }

    @Test
    public void testDelete() {
        final Integer id = 17;
        final User userById = userMapper.findUserById(id);
        assertNotNull(userById);

        userMapper.delete(id);

        final User user = userMapper.findUserById(id);
        assertNull(user);
    }
}
