package com.jaon.demo.controller;

import com.jaon.demo.component.PtpProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gao
 * @date 2018/7/19 15:49
 * 2.主题/订阅,发布订阅模式
 */
@RestController
@RequestMapping(value = "/pubsub")
public class PubSubController {
    @Resource
    private PtpProducer ptpProducer;


    @RequestMapping(value = "/convertAndSend")
    public String convertAndSend(){
        ptpProducer.convertAndSend2();
        return "success";
    }
}
