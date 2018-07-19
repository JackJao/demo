package com.jaon.demo.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Gao
 * @date 2018/7/19 15:31
 * 消息队列多消费者，配置多个监听器，并指定containerFactory属性即可
 */
@Component
public class PtpListener2 {
    /**
     * 消息队列监听器
     * destination 队列地址
     * containerFactory 监听器容器工厂, 若存在2个以上的监听容器工厂,需进行指定
     */
    @JmsListener(destination = "ptp", containerFactory = "jmsQueueListenerCF")
    public void receive(String msg){

        System.out.println("点对点模式2: " + msg);

    }
}
