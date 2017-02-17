package com.example.linsawako.crazytranslation.base.common;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.type;
import static android.icu.lang.UCharacter.JoiningGroup.PE;

/**
 * Created by linsawako on 2017/2/16.
 */

public class Config {

    /*
    * 有道词典api
    * http://fanyi.youdao.com/openapi.do?keyfrom=crazyTranslation&key=390291808&type=data&doctype=json&version=1.1&q=java
    * */

    public final static String URL = "http://fanyi.youdao.com";

    public final static String KEYFROME = "crazyTranslation";

    public final static String KEY = "390291808";

    public final static String TYPE = "data";

    public final static String DOCTYPE = "json";

    public final static String VERSION = "1.1";

    private static Map<String, String> params = new HashMap<>();

    public static Map<String, String> getParams(){
        params.put("keyfrom", KEYFROME);
        params.put("key", KEY);
        params.put("type", TYPE);
        params.put("doctype", DOCTYPE);
        params.put("version", VERSION);

        return params;
    }

}
