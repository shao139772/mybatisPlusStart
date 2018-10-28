package com.miaomiao.bootwithmybatisplus.common.utils;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by cw on 2018/10/22.
 * json返回类
 */
public class JsonResulte extends HashMap<String, Object> {

    public JsonResulte() {
        put("code", 0);
        put("msg", "success");
    }

    public static JsonResulte error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static JsonResulte error(String msg) {
        return error(500, msg);
    }

    public static JsonResulte error(int code, String msg) {
        JsonResulte r = new JsonResulte();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static JsonResulte ok(String msg) {
        JsonResulte r = new JsonResulte();
        r.put("msg", msg);
        return r;
    }

    public static JsonResulte ok(Map<String, Object> map) {
        JsonResulte r = new JsonResulte();
        r.putAll(map);
        return r;
    }

    public static JsonResulte ok() {
        return new JsonResulte();
    }

    @Override
    public JsonResulte put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
