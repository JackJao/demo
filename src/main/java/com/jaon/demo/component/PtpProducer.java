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
     * 发送消息自动转换成原始消息
     */
    public void convertAndSend(){
        jmsTemplate.convertAndSend("ptp", "我是自动转换的消息");
    }


    /**
     * 2.
     */
    public void convertAndSend2(){
       // jmsTemplate.convertAndSend("topic", "我是自动转换的消息topic");
    }
}
