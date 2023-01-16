package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public RedisConnection getJedis() {
        RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
        return factory.getConnection();
    }

    public boolean set(String key, String value) {
        try (RedisConnection r = getJedis()) {
            return r.set(key.getBytes(), value.getBytes());
        } catch (Exception e) {

        }
        return false;
    }

    public String get(String key) {
        try (RedisConnection r = getJedis()) {
            byte[] rs = r.get(key.getBytes());
            return new String(rs);
        } catch (Exception e) {

        }
        return null;
    }

}
