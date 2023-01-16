package com.example.springboot.controller;

// 注意: commons-logging 通过 LogFactory.getLog() 获取日志，而 log4j 通过 Logger.getLog() 获取
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    private Log logger = LogFactory.getLog(TestController.class.getName());

    @RequestMapping(value = "/api/testApi", method = RequestMethod.GET)
    public String testApi() {
        logger.info("hello world");
        return "hello world";
    }

    @RequestMapping(value = "/api/testApi2", method = RequestMethod.GET)
    public Map<String, String> testApi2() {
        Map<String, String> res = new HashMap<>();
        res.put("code", "200");
        res.put("msg", "hello world");
        logger.info(res);
        return res;
    }

}
