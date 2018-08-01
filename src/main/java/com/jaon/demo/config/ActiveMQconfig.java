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
     * jmsTemplate
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsTemplate JmsTemplate(ConnectionFactory connectionFactory){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        //开启发布订阅功能，默认未开启,默认使用队列模式,使用主题模式后队列模式失效，2选1
        //2.
        //jmsTemplate.setPubSubDomain(true);
        /**
         * 消息的递送模式
         在发送消息给时，可以告知这是持久化的消息，还是非持久化的消息。如果是非持久化的消息，broker会将消息保留在内存，否则就会持久化到磁盘。非持久化：高吞吐，易丢失；持久化：低吞吐，不易丢失。
         相关的API：
         Class org.springframework.jms.core.JmsTemplate
         public void setDeliveryMode(int deliveryMode)
         设置是否持久化要发送的消息：1-非持久化；2-持久化
         public int getDeliveryMode()
         获取持久化模式的设置：1-非持久化；2-持久化
         public void setDeliveryPersistent(boolean deliveryPersistent)
         设置是否持久化要发送的消息，true-持久化；false-非持久化
         */

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

    /**
     * 2.JMS主题的监听容器工厂
     * @param connectionFactory
     * @return
     */
    @Bean(name = "jmsTopicListenerCF")
    public DefaultJmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //设置连接数
        factory.setConcurrency("1");
        //使其支持发布订阅功能
        factory.setPubSubDomain(true);
        return factory;
    }
}
