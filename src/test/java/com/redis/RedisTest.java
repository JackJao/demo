package com.redis;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.jaon.demo.config.RedisConfig;
import com.jaon.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisKeyCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
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

    /*@Test
    public void test2(){
        Long hello = redisTemplate.getExpire("hello");
        System.out.println(hello);
        System.out.println("过期时间："+(hello==-1L?"永久":hello==-2L?"不存在":hello));
        redisTemplate.opsForValue().set("number".toString(),"10010".toString());
        System.out.println("number="+redisTemplate.opsForValue().get("number"));
    }*/

    @Test
    public void test3(){
        Long hello = stringRedisTemplate.getExpire("hello");
        System.out.println(hello);
        System.out.println("过期时间："+(hello==-1L?"永久":hello==-2L?"不存在":hello));
        stringRedisTemplate.opsForValue().set("stringkey","value");
        System.out.println(stringRedisTemplate.opsForValue().get("stringkey"));
    }

    @Test
    public void test4(){
        User u = new User();
        u.setId(1L);
        u.setCode(10010);
        u.setName("联通");
        u.setBirthday(new Date());
        u.setCreaterTime(new Date());
        /*redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new FastJsonRedisSerializer<User>(User.class));
        redisTemplate.opsForValue().set("123",u);*/
        String s = JSON.toJSONString(u);
        redisTemplate.opsForValue().set("123",s);
        Object o = redisTemplate.opsForValue().get("123");
        System.out.println("user = "+o);
    }
}
