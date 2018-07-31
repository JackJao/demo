package com.jaon.demo.component;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Gao
 * @date 2018/7/19 15:27
 * 消息生产者消息生产者
 */
@Component
public class PtpProducer {
    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * 1.消息队列
     */
    public void sendQueues(){
        jmsTemplate.convertAndSend("queues.msg.list", "队列消息列表");
    }


    /**
     * 2.主题/订阅
     */
    public void sendTopic(){
        jmsTemplate.convertAndSend("topic.msg.list", "主题消息列表");
    }
}
