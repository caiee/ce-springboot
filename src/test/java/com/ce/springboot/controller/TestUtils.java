package com.ce.springboot.controller;

import com.ce.springboot.config.RawString;
import org.junit.Test;

/**
 * @author caie
 * @since 2016/12/3
 */
public class TestUtils {

    @Test
    public void testRawString() {
        final RawString rawString = new RawString("asdjf");
        System.out.println(rawString.toString());
    }
}
