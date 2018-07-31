package com.jms;

import com.jaon.demo.config.ActiveMQconfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author Gao
 * @date 2018/7/18 15:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ActiveMQconfig.class})
public class JmsTest {

    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * 发消息
     */
    @Test
    public void test1(){
        jmsTemplate.send("消息队列-1", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("原始方式发送消息-消息队列1-我是消息内容");
            }
        });
    }

    /**
     * 接受消息
     */
    @Test
    public void test2() throws JMSException {
        Message receive = jmsTemplate.receive("消息队列-1");
        System.out.println("获取，消息队列-1，的消息内容：【"+((TextMessage)receive).getText()+"】");
    }

    /**
     *  优化 send
     */
    @Test
    public void test3(){
        jmsTemplate.convertAndSend("优化-消息队列-1","优化-消息队列-1-我是消息内容");
    }

    /**
     * 优化接受
     */
    @Test
    public void test4(){
        Object queue1 = jmsTemplate.receiveAndConvert("优化-消息队列-1");
        System.out.println("获取，优化-消息队列-1，的消息内容【"+queue1+"】");
    }
}