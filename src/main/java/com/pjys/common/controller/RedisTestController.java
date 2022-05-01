package com.pjys.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedisTestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("redis/test")
    public void test(){
        redisTemplate.opsForValue().set("test_key","test_value");
        System.out.println(redisTemplate.opsForValue().get("test_key"));
    }
}
