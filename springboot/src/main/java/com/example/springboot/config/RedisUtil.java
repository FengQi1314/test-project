package com.example.springboot.config;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public RedisConnection getJedis() {
        RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
        return factory.getConnection();
    }

    public boolean set(String key, Object value) {
        try (RedisConnection r = getJedis()) {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(value);
            byte[] a = bo.toByteArray();
            return r.set(key.getBytes(), a);
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
