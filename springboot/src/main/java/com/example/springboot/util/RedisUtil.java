package com.example.springboot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    private RedisConnection getConn() {
        return redisConnectionFactory.getConnection();
    }

    public boolean set(String key, String value) {
        try (RedisConnection conn = getConn()) {
            return conn.set(key.getBytes(), value.getBytes());
        } catch (Exception e) {

        }
        return false;
    }

    public String get(String key) {
        try (RedisConnection conn = getConn()) {
            return new String(conn.get(key.getBytes()));
        } catch (Exception e) {

        }
        return null;
    }

}
