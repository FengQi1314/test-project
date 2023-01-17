package com.example.springboot;

import com.example.springboot.util.RedisUtil;
import com.example.springboot.module.dao.TestDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private TestDAO testDAO;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
    }

    @Test
    void testDaoAccess() {
        System.out.println(testDAO.getUser());
    }

    @Test
    void testRedis() {
        // 设置Redis的值
        System.out.println(redisUtil.set("1", "abc"));
        System.out.println(redisUtil.set("2", "abc!%fdadfefda"));
        Long[] a = new Long[]{1L, 2L, 3L};
        System.out.println(redisUtil.set("3", Arrays.toString(a)));

        // 获取Redis的值
        System.out.println(redisUtil.get("1"));
        System.out.println(redisUtil.get("2"));
        System.out.println(redisUtil.get("3"));
        System.out.println(redisUtil.get("4"));
    }

}
