package com.ynd.jiekou.wework.contact;

import com.ynd.jiekou.wework.Restful;
import com.ynd.jiekou.wework.Wework;
import io.restassured.http.ContentType;

public class Contact extends Restful {
    public Contact() {  //初始化
        reset();
    }
    public void reset() {
        requestSpecification
                .log().all()
                .queryParam("access_token", Wework.getToken())
                .contentType(ContentType.JSON);
    }
}

