package com.example.springboot;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.springboot.util.RedisUtil;
import com.example.springboot.module.dao.TestDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 核心测试类
 *
 * 注释说明：
 * @SpringBootTest 默认Mock环境，启动虚拟的web环境，进行模拟; 没有创建隐含的port端口;
 * @AutoConfigureMockMvc 自动配置SpringMvcMock，注入时使用 MockMvc 不是 webMockClient
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpringbootApplicationTests {

    @Autowired
    private TestDAO testDAO;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
    }

    @Test
    void testTestApiController(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/api/testApi"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello world1"));
    }

    @Test
    void testTestApi4Controller(@Autowired MockMvc mvc) throws Exception {
        Map<String, String> body = new HashMap<>();
        body.put("id", "1");
        body.put("name", "小明");

        Map<String, Object> expectJson = new HashMap<>();
        expectJson.put("msg", "hello world");
        expectJson.put("code", "200");

        mvc.perform(post("/api/testApi4").contentType(MediaType.APPLICATION_JSON).content(JSONUtils.toJSONString(body)))
                .andExpect(status().isOk())
                .andExpect(content().json(JSONUtils.toJSONString(expectJson)));
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
