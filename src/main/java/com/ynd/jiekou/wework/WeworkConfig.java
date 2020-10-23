package com.ynd.jiekou.wework;

public class WeworkConfig {
    //配置参数
    public String cookies = "cookies";
    public String ip = "ip";

    //单例维护配置为唯一对象
    private static WeworkConfig config;
    public static WeworkConfig getInstance(){
        if (config==null){
            config = new WeworkConfig();
        }
        return config;
    }

    //读取配置文件
    public static void load(String path){
        //todo: read from yaml
    }

}
