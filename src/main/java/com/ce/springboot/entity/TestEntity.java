package com.ce.springboot.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author caie
 */
public class TestEntity {

    private Integer id;

    private String name;

    private Double score;

    private BigDecimal price;

    private LocalDateTime time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
