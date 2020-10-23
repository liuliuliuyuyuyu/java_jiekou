package com.ynd.jiekou.wework.contact;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.ynd.jiekou.wework.Wework;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class Member extends Contact{    //重新封装，把尽可能多的不变的东西封装起来,把这个类继承封装的类
    public Response list(String id, HashMap<String,Object> map){        //这里使用HashMap获取多个数据
        DocumentContext documentContext = JsonPath.parse(this.getClass().getResourceAsStream("/data/create.json"));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });
        Response response = requestSpecification
                .queryParam("id",id)
                .body(documentContext.jsonString())
                .when().post("xxx")
                .then().extract().response();
        reset();
        return response;
//        return
//        given().log().all()
//            .queryParam("access_token", Wework.getToken())
//            .queryParam("id",id)
//        .when().
//            get("xxx")
//        .then()
//            .statusCode(200)        //这里先进行最基础的code的断言
//            .extract().response();  //这个相当于就是python中的response，提取出response为更深层次的断言
    }
    public Response create(String name,String memberid) {
        String data = JsonPath.parse(this.getClass()
                .getResourceAsStream("/data/create.json"))//读取json文件，相当于读取格式
                .set("$.name",name)                             //修改json文件，修改格式中的特定数据
                .set("memberid",memberid).jsonString();
        return given().log().all()
                .queryParam("access_token",Wework.getToken())
                .body(data)
                .when().post("xx")
                .then().statusCode(200).extract().response();
    }
    //restful重构读取har文件后这个函数的变更
    public Response update(HashMap<String,Object> map){
        return templateFromHar(
                "/data/demo.har.json",
                "http://",
                map
        );
    }
}
