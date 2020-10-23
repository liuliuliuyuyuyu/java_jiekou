package com.ynd.jiekou.wework.contact;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.*;

public class vipTest {

    static vip vip;
    @BeforeClass
    static void setUp() {
        vip = new vip();
    }

    //这里的传参可以使用参数化数据驱动的方式传入    @Test(dataProvider = "",dataProviderClass = "")
    @Test
    public void testCreate(String id,String name,String age) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("age",age);
        vip.create(map).then().statusCode(200);
    }
}