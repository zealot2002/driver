package com.zzy.common.utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzy
 * @date 2018/9/14
 */

public class JsonUtils {

    public static String getString(String key,String json) throws Exception{
        JSONTokener jsonParser = new JSONTokener(json);
        JSONObject obj = (JSONObject) jsonParser.nextValue();
        return obj.getString(key);
    }
    public static long getLong(String key,String json) throws Exception{
        JSONTokener jsonParser = new JSONTokener(json);
        JSONObject obj = (JSONObject) jsonParser.nextValue();
        return obj.getLong(key);
    }
    public static double getDouble(String key,String json) throws Exception{
        JSONTokener jsonParser = new JSONTokener(json);
        JSONObject obj = (JSONObject) jsonParser.nextValue();
        return obj.getDouble(key);
    }

//    public static String map2Json(Map map){
//        return JSONUtils.toJSONString(map);
//    }


}
