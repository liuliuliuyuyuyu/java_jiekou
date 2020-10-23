package com.ynd.jiekou.wework.contact;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class memberTest {
    Member member;
    String random = String.valueOf(System.currentTimeMillis());//生成一个时间戳，放到名字中，保证数据的唯一与随机
    @BeforeClass
    public void setUp() {
        member = new Member();
    }
    @Test
    public void testlist() {
        HashMap<String,Object> map = new HashMap<>();
        member.list("id",map).then();
    }

    @Test
    public void testCreate() {
        member.create("yuhua","123").then();
    }
}