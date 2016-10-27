package com.ce.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caie
 */
@RestController
public class HelloController {

    @GetMapping(value = "/")
    public String getString() {
        return "Hello Spring Boot";
    }

}
