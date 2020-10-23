package com.ynd.jiekou.wework.contact;

import io.restassured.response.Response;

import java.util.HashMap;

public class vip extends Contact{
    public Response create(HashMap<String,Object> map){
        String body = template("/data/create.json",map);
        reset();
        return requestSpecification.body(body).post("").then().extract().response();
    }
}
