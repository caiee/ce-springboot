package com.ce.springboot.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ReturnValue implements Serializable {
    private static final long serialVersionUID = -3217633508940695532L;
    private boolean success;
    private Object data;

    public ReturnValue(boolean flag) {
        success = flag;
    }

    public ReturnValue(boolean flag, Object code, String error) {
        success = flag;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("code", code);
        paramMap.put("error", error);
        data = paramMap;
    }

    public ReturnValue(boolean flag, Object data) {
        success = flag;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
