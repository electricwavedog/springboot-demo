package com.example.springbootdemo.service.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author liuyiqian
 */
@Service
public class CacheServiceImp implements CacheService{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void saveString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void saveObject(Object key, Object obj) {
        redisTemplate.opsForValue().set(key, obj);
    }

    @Override
    public Object getObject(Object key) {
        return redisTemplate.opsForValue().get(key);
    }
}
