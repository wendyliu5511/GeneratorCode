package com.cn.generator.util;

import java.io.Serializable;

/**
 * @program: generator_pro
 * @description:
 * @author: lmm
 * @create: 2019-12-22 16:22
 **/
public class RestInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success;
    private String message;
    private Integer code;
    private long timestamp = System.currentTimeMillis();
    private T result;

    public RestInfo() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
