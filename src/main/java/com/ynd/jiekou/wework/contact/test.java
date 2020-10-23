package com.ynd.jiekou.wework.contact;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap<String,Object> query = new HashMap<String, Object>();
        query.put("name","yuhua");
        query.put("age","20");
        System.out.println(query);
        query.put("name","bifang");
        query.entrySet().forEach(entry->{
            System.out.println(entry);
        });
    }
}
