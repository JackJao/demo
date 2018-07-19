package com.jaon.demo.controller;

import com.jaon.demo.component.PtpProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gao
 * @date 2018/7/19 15:29
 * 消息队列 单消费者/多消费者
 */
@RestController
@RequestMapping(value = "/ptp")
public class PtpController {
    @Resource
    private PtpProducer ptpProducer;

    @RequestMapping(value = "/convertAndSend")
    public Object convertAndSend(){
        ptpProducer.convertAndSend();
        return "success";
    }

}
