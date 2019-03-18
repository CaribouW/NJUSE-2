package com.example.main.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JsonUtils {
    JSONObject obj;

    /**
     * note: 将正常对象转换为JSONObject
     *
     * @param obj
     */
    public JSONObject toJSONObject(Object obj) {
        return (JSONObject) JSON.toJSON(obj);
    }

    /**
     * @param obj  传入的对象
     * @param args 传入对象需要保留的参数名组成的数组
     * @return JSONObject对象
     */
    public JSONObject toJSONObject(Object obj, String... args) {
        JSONObject temp = new JSONObject();                //将传入的obj转换成json对象
        temp = (JSONObject) temp.toJSON(obj);
        JSONObject result = new JSONObject();            //创建结果
        for (String arg : args) {
            result.put(arg, temp.get(arg));
        }
        return result;
    }

    @SuppressWarnings("static-access")
    public JSONObject toJSONObject(Object obj, ArrayList<String> list) {
        JSONObject temp = new JSONObject();                //将传入的obj转换成json对象
        temp = (JSONObject) temp.toJSON(obj);
        JSONObject result = new JSONObject();                //创建结果
        for (int i = 0; i < list.size(); i++) {
            try {
                result.put(list.get(i), temp.get(list.get(i)));
            } catch (NumberFormatException e) {                //若读数字出错，则读字符串
                result.put(list.get(i), temp.getString(list.get(i)));
            }
        }
        return result;
    }


    /**
     * @param list 传入的根据selectbyExample返回的list
     * @return list里的对象拼接成的JSONArray
     */
    public JSONArray toJSONArray(List<?> list) {
        JSONArray array = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            array.add(list.get(i));
        }
        return array;
    }

    public JSONArray toJSONArray(List<?> list, ArrayList<String> params) {
        JSONArray array = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            array.add(toJSONObject(list.get(i), params));
        }
        return array;
    }


    /**
     * @param object 要转换成JSONArray的object对象，参数可变长
     * @return
     */
    public JSONArray combineToArray(Object... object) {
        JSONArray result = new JSONArray();
        for (Object obj : object) {
            result.add(obj);
        }
        System.out.println(result.toJSONString());
        return result;
    }

    /**
     * note: 将一些不同对象的参数合并到一个对象中
     *
     * @param objects
     */
    public JSONObject combineToObject(Object... objects) {
        StringBuilder result = new StringBuilder("{");
        for (Object obj : objects) {
            JSONObject temp1 = (JSONObject) JSON.toJSON(obj);
            String temp2 = temp1.toJSONString();
            temp2 = temp2.substring(1, temp2.length() - 1);
            result.append(temp2).append(",");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        result.append("}");
        return JSON.parseObject(result.toString());
    }
}
