package com.angers.project.onjava8.object;

import java.util.Map;

public class ShowProperties {

    public static void main(String[] args) {
        // 获取所有的系统属性配置
        System.getProperties().list(System.out);
        // 获取某一项具体的配置
        System.out.println(System.getProperty("user.name"));
        // 遍历环境变量
        Map<String,String> envMap = System.getenv();
        envMap.forEach((k,v)-> System.out.println(k+"="+v));
    }
}
