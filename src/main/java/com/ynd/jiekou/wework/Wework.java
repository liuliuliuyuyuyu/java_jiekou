package com.ynd.jiekou.wework;

public class Wework {
    private static String token;
    public static String getWeworkToken(){
        //todo: return token,使用.extract().path("access_token")获取token,调用WeworkConfig.getInstance()获取获取token接口请求的数据
        return WeworkConfig.getInstance().cookies;
    }
    public static String getToken(){
        if (token==null){
            token=getWeworkToken();
        }
        return token;
    }
}
