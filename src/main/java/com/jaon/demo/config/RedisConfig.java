package com.jaon.demo.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.jaon.demo.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Gao
 * @date 2018/7/17 16:54
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        //如果什么参数都不设置，默认连接本地6379端口
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPort(6379);
        factory.setHostName("192.168.0.80");
        return factory;
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        //创建一个模板类
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        //将刚才的redis连接工厂设置到模板类中
        template.setConnectionFactory(redisConnectionFactory);
        //设置默认使用String的序列化储存key-value
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        template.setDefaultSerializer(stringSerializer);
        /*template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new FastJsonRedisSerializer<User>(User.class));*/
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        return new StringRedisTemplate(redisConnectionFactory);
    }
}
