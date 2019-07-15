package com.nowcoder.model;

import java.util.HashMap;

/**
 * Created by lenovo on 2019/7/15.
 */
public class ViewObject {
    private HashMap<String,Object> map=new HashMap<>();
    public void set(String key,Object value){
        map.put(key,value);
    }
    public Object get(String key){
        return map.get(key);
    }
}
