package com.redis;

import com.jaon.demo.config.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisKeyCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Gao
 * @date 2018/7/17 17:24
 */
@SpringBootTest(classes = RedisConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {

    @Resource
    private RedisConnectionFactory factory;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1(){
        RedisConnection connection = factory.getConnection();
        connection.set("hello".getBytes(),"你好".getBytes());
        String ping = connection.ping();
        System.out.println("获取hello:"+new String(connection.get("hello".getBytes())));
        System.out.println("ping:"+ping);
        RedisKeyCommands redisKeyCommands = connection.keyCommands();
        Set<byte[]> keys = redisKeyCommands.keys("*".getBytes());
        Iterator<byte[]> iterator = keys.iterator();
        System.out.println("keys：");
        while (iterator.hasNext()){
            System.out.println(new String(iterator.next()));
        }
    }

    @Test
    public void test2(){
        Long hello = redisTemplate.getExpire("hello");
        System.out.println(hello);
        System.out.println("过期时间："+(hello==-1L?"永久":hello==-2L?"不存在":hello));
        redisTemplate.opsForValue().set("number".toString(),"10010".toString());
        System.out.println("number="+redisTemplate.opsForValue().get("number"));
    }

    @Test
    public void test3(){
        Long hello = stringRedisTemplate.getExpire("hello");
        System.out.println(hello);
        System.out.println("过期时间："+(hello==-1L?"永久":hello==-2L?"不存在":hello));
        stringRedisTemplate.opsForValue().set("stringkey","value");
        System.out.println(stringRedisTemplate.opsForValue().get("stringkey"));
    }
}
