package com.jaon.demo.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Gao
 * @date 2018/7/19 15:31
 * 单消费者，只有这一个消息队列的监听器
 */
@Component
public class PtpListener1 {
    /**
     * 消息队列监听器
     * destination 队列地址
     * containerFactory 监听器容器工厂, 若存在2个以上的监听容器工厂,需进行指定
     */
    @JmsListener(destination = "queues.msg.list", containerFactory = "jmsQueueListenerCF")
    public void receive(String msg){

        System.out.println("点对点模式1(一个消费者): " + msg);

    }
}
