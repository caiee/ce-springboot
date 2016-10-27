package com.ce.springboot.controller;

import com.ce.springboot.ApplicationBaseTest;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTestCaseTemplate extends ApplicationBaseTest {

    @Test
    public void testGetUser() throws Exception {
        Assert.assertNotNull(mockMvc);

        // Get请求, 无参数, 返回单个元素
        mockMvc.perform(get("/a"))
                // 判断 HttpCode
                .andExpect(status().isOk())
                // 可以打印
                .andDo(print())
                // 判断返回的 contentType
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                // 判断 返回数据的值
                .andExpect(jsonPath("$.data.name").value("user name"))
                .andExpect(jsonPath("$.data.age").value(20));

    }

    @Test
    public void testGetUsers() throws Exception {
        // Get请求, 获取用户(List结果)
        mockMvc.perform(get("/b"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.data", hasSize(greaterThan(7))))
                .andExpect(jsonPath("$.data[0].id", is(11)))
                .andExpect(jsonPath("$.data[0].name", is("11-user name")))
                .andExpect(jsonPath("$.data[0].age", is(11)))
                .andExpect(jsonPath("$.data[1].id", is(12)))
                .andExpect(jsonPath("$.data[1].name", is("12-user name")))
                .andExpect(jsonPath("$.data[1].age", is(12)));
    }

    @Test
    public void testUpdateUserInfo() throws Exception {
        // POST请求, 修改用户状态
        final Integer id = 11;
        final String phone = "123456";

        mockMvc.perform(post("/c?id={id}&phone={phone}", id, phone))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.data.message").value("更新成功"))
                .andExpect(jsonPath("$.data.data", is("hehe")));
    }

    @Test
    public void testGetUserById() throws Exception {
        // Get请求, 根据参数, 请求返回单个元素
        final Integer id = 11;
        mockMvc.perform(get("/d/{id}", id))
                // 判断 HttpCode
                .andExpect(status().isOk())
                // 判断返回的 contentType
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.data.name").value("user name"))
                .andExpect(jsonPath("$.data.id").value(id));
    }

    @Test
    public void testDeleteUser() throws Exception {
        final Integer id = 15;

        mockMvc.perform(delete("/e/{id}", id))
                .andExpect(status().isOk())
                // 判断返回的 contentType
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.data.message").value("更新成功"));
    }
}