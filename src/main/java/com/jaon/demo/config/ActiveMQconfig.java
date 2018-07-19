package com.jaon.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

/**
 * @author Gao
 * @date 2018/7/18 14:41
 * 消息队列
 * 参考
 * http://www.cnblogs.com/niit-soft-518/p/6957384.html
 */
@Configuration
@EnableJms
public class ActiveMQconfig {

    /**
     * 连接工厂
     * @return
     */
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("tcp://localhost:61616");
        factory.setUserName("root");
        factory.setPassword("root");
        return factory;
    }

    /**
     * 暂无用
     * @return
     */
    @Bean
    public ActiveMQQueue activeMQQueue(){
        ActiveMQQueue queue = new ActiveMQQueue("demo.queue");
        return queue;
    }

    /**
     * 暂无用
     * @return
     */
    @Bean
    public ActiveMQTopic activeMQTopic(){
        ActiveMQTopic queue = new ActiveMQTopic("demo.topic");
        return queue;
    }

    /**
     * jmsTemplate
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsTemplate JmsTemplate(ConnectionFactory connectionFactory){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        //开启发布订阅功能，默认未开启,默认使用队列模式,使用主题模式后队列模式失效，2选1
        //2.jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }


    /**
     * JMS 队列的监听容器工厂
     */
    @Bean(name = "jmsQueueListenerCF")
    public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //设置连接数
        factory.setConcurrency("3-10");
        //重连间隔时间
       factory.setRecoveryInterval(1000L);
        return factory;
    }

    /*2.@Bean(name = "jmsTopicListenerCF")
    public DefaultJmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //设置连接数
        factory.setConcurrency("1");
        //使其支持发布订阅功能
        factory.setPubSubDomain(true);
        return factory;
    }*/
}
