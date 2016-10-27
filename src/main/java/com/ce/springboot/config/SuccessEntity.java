package com.ce.springboot.config;

/**
 * @author caie
 * @since 16/9/2
 */
public class SuccessEntity {

    private String message;

    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
