package com.jaon.demo.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 * redis集成配置两种方式：1.原生jedis-pool操作；2.spring-data中的RedisTemplate和StringRedisTemplate
 * RedisTemplate中RedisConnectionFactory有两种reids的java实现LettuceConnectionFactory|JedisConnectionFactory
 * @author Gao
 * @date 2018/7/17 16:54
 */
@Configuration
public class RedisConfig {

    /**
     * RedisStandaloneConfiguration             标准配置
     * RedisClusterConfiguration                集群配置
     * RedisStaticMasterReplicaConfiguration    静态复制配置
     * RedisSentinelConfiguration               哨兵配置
     * RedisSocketConfiguration                 套接字配置
     * Redis连接工厂配置
     * @return redisConnectionFactory
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        //如果什么参数都不设置，默认连接本地6379端口,默认使用标准配置
        RedisStandaloneConfiguration cfg = new RedisStandaloneConfiguration("192.168.199.181",6379);
        //选择数据库
        cfg.setDatabase(0);
        //默认密码为空，密码不为空=>>"cfg.setPassword(RedisPassword.of("密码"));"
        cfg.setPassword(RedisPassword.none());
        //加载配置
        JedisConnectionFactory factory = new JedisConnectionFactory(cfg);
        //配置连接池,请自定义需要的属性配置
        GenericObjectPoolConfig poolConfig = factory.getPoolConfig();
        poolConfig.setMaxTotal(30);
        //默认0
        poolConfig.setMinIdle(0);
        poolConfig.setMaxIdle(10);
        poolConfig.setMaxWaitMillis(3000L);
        //-1
        poolConfig.setNumTestsPerEvictionRun(1024);
        poolConfig.setTimeBetweenEvictionRunsMillis(30000L);
        //3分钟，默认60s
        poolConfig.setMinEvictableIdleTimeMillis(1800000L);
        //10s
        poolConfig.setSoftMinEvictableIdleTimeMillis(10000L);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestWhileIdle(true);
        //默认false
        poolConfig.setBlockWhenExhausted(false);
        poolConfig.setJmxEnabled(true);

        //初始化参数
        factory.afterPropertiesSet();
        return factory;
    }

    /**
     * Redis通用操作模板
     * @param redisConnectionFactory
     * @return redisTemplate
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        //创建一个模板类
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //将刚才的redis连接工厂设置到模板类中
        template.setConnectionFactory(redisConnectionFactory);
        //设置key采用String的序列化
        RedisSerializer<String> keySerializer = new StringRedisSerializer();
        template.setKeySerializer(keySerializer);
        template.setHashKeySerializer(keySerializer);
        //设置value采用jdk的序列化
        RedisSerializer<Object> valueSerializer = new JdkSerializationRedisSerializer();
        //设置value采用FastJson的序列化
        RedisSerializer<Object> valueSerializer2 = new FastJsonRedisSerializer(Object.class);
        //设置value采用Jackson2Json的序列化
        RedisSerializer<Object> valueSerializer3 = new Jackson2JsonRedisSerializer(Object.class);
        template.setValueSerializer(valueSerializer);
        template.setHashValueSerializer(valueSerializer);
        //初始化参数
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 普通的String类型Redis操作模板
     * @param redisConnectionFactory
     * @return stringRedisTemplate
     */
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        return new StringRedisTemplate(redisConnectionFactory);
    }
}