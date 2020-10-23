package com.ynd.jiekou.wework;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Restful {
    //封装初始化requestSpecification，这个是默认值
    HashMap<String,Object> query = new HashMap<String, Object>();
    public RequestSpecification requestSpecification;

    public Response send() {
        requestSpecification = given().log().all();
        query.entrySet().forEach(entry->{
            requestSpecification.queryParam(entry.getKey(),entry.getValue());
        });
        return requestSpecification.when().request("get","baidu.com");
    }

    //封装初始化读取json文件
    public static String template(String path,HashMap<String,Object> map){
        DocumentContext documentContext = JsonPath.parse(Restful.class.getResourceAsStream(path));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });
        return documentContext.jsonString();
    }
    //封装初始化读取har
    public  Response templateFromHar(String path,String urlfile,HashMap<String,Object> map){
        //
        DocumentContext documentContext = JsonPath.parse(Restful.class.getResourceAsStream(path));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });

        String method = documentContext.read("method");
        String url = documentContext.read("url");
        return requestSpecification.when().request(method,url);
    }
}
