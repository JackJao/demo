package com.jaon.demo.controller;

import com.jaon.demo.component.PtpProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gao
 * @date 2018/7/19 15:49
 * 2.主题/订阅,发布订阅模式
 */
@RestController
@RequestMapping(value = "/topic")
public class TopicController {
    private static final Logger log = LoggerFactory.getLogger(QueuesController.class);
    @Resource
    private PtpProducer ptpProducer;


    @RequestMapping(value = "/send")
    public String convertAndSend(){
        ptpProducer.sendTopic();
        log.error("error");
        return "success";
    }
}
