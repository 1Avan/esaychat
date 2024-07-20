package com.ivan.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig<V> {
    @Bean("redisTemplate")
    public RedisTemplate<String ,V>redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String ,V> redisTemplate = new RedisTemplate<String, V>();
        redisTemplate.setConnectionFactory(factory);
        //设置key的序列化方式
        redisTemplate.setKeySerializer(RedisSerializer.string());
        //设置value的序列化方式
        redisTemplate.setValueSerializer(RedisSerializer.json());
        //设置hash的key的序列化方式
        redisTemplate.setHashKeySerializer(RedisSerializer.json());
        //设置hash的value的序列化方式
        redisTemplate.afterPropertiesSet();
        return redisTemplate;

    }
}
