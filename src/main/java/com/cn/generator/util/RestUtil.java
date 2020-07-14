package com.cn.generator.util;

/**
 * @program: generator_pro
 * @description:
 * @author: lmm
 * @create: 2019-12-22 16:24
 **/
public class RestUtil {
    public RestUtil() {
    }

    public static <T> RestInfo<T> setData(T t) {
        return setSuccessData(t, (String)null);
    }

    public static RestInfo setSuccessMsg(String msg) {
        return setSuccessData((Object)null, msg);
    }

    public static <T> RestInfo<T> setSuccessData(T t, String msg) {
        RestInfo<T> result = new RestInfo();
        result.setSuccess(true);
        result.setResult(t);
        result.setCode(200);
        result.setMessage(msg);
        return result;
    }

    public static RestInfo setErrorMsg(String msg) {
        return setErrorAll(500, msg, (Object)null);
    }

    public static <T> RestInfo<T> setErrorMsg(T t, String msg) {
        return setErrorAll(500, msg, t);
    }

    public static RestInfo setErrorCode(Integer code, String msg) {
        return setErrorAll(code, msg, (Object)null);
    }

    public static <T> RestInfo<T> setErrorAll(Integer code, String msg, T t) {
        RestInfo<T> result = new RestInfo();
        result.setSuccess(false);
        result.setMessage(msg);
        result.setCode(code);
        result.setResult(t);
        return result;
    }
}
