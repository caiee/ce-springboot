package com.ce.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author caie
 * @since 16/9/1
 */
@ConfigurationProperties(prefix = "person", locations = "classpath:${spring.profiles.active}/config.yml")
@Component
public class InjectYmlField {
    private String name;

    private Integer age;

    private Double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
