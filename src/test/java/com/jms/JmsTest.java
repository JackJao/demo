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
        jmsTemplate.send("demo2.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("原始消息");
            }
        });
    }

    /**
     * 接受消息
     */
    @Test
    public void test2() throws JMSException {
        Message receive = jmsTemplate.receive("demo2.queue");
        System.out.println(((TextMessage)receive).getText());
    }

    /**
     *  优化 send
     */
    @Test
    public void test3(){
        jmsTemplate.convertAndSend("queue1","队列消息1");
    }

    /**
     * 优化接受
     */
    @Test
    public void test4(){
        Object queue1 = jmsTemplate.receiveAndConvert("queue1");
        System.out.println(queue1);
    }
}