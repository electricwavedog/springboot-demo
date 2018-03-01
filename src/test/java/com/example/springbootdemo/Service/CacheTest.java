package com.example.springbootdemo.Service;

import com.example.springbootdemo.SpringbootDemoApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuyiqian
 * @version 1.0
 * @description
 * @date 2017/12/22 上午10:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(SpringbootDemoApplicationTests.class)
public class CacheTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void stringTest() {
        stringRedisTemplate.opsForValue().set("a", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("a"));
    }
}
