package com.ce.springboot.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 请求参数错误.
 * Created by zhaimi on 15/10/31.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidArgumentException extends Exception {

    /**
     * 无参构造方法.
     */
    public InvalidArgumentException() {
        super();
    }

    /**
     * 有参构造方法.
     *
     * @param s 参数
     */
    public InvalidArgumentException(final String s) {
        super(s);
    }
}
