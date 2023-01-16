package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping(value = "/api/testApi", method = RequestMethod.GET)
    public String testApi() {
        return "hello world";
    }

    @RequestMapping(value = "/api/testApi2", method = RequestMethod.GET)
    public Map<String, String> testApi2() {
        Map<String, String> res = new HashMap<>();
        res.put("code", "200");
        res.put("msg", "hello world");
        return res;
    }

}
