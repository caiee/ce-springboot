package com.ce.springboot.config;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * Created by zhyk on 10/30/15.
 */
@JsonSerialize(using = ToStringSerializer.class)
public final class RawString {
    private String string;

    public RawString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
