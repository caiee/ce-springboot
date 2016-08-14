package com.ce.springboot.controller;

import com.ce.springboot.entity.TestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author caie
 */
@RestController
public class TestController {

    @GetMapping(value = "/")
    public String getString() {
        return "Hello Spring Boot";
    }

    @GetMapping("test")
    public TestEntity getTestEntity() {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(1);
        testEntity.setName("123");
        testEntity.setPrice(new BigDecimal(10));
        testEntity.setScore(new Double("1"));
        testEntity.setTime(LocalDateTime.now());
        return testEntity;
    }
}
