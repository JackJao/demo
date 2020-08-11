package com.jaon.demo.component.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * @author Gao
 * @date 2018/8/2 14:31
 */
public class MarcoHandler2 extends AbstractWebSocketHandler {

    private static final Logger log = LoggerFactory.getLogger(MarcoHandler2.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        log.info("接受的消息2："+message.getPayload());
        Thread.sleep(3000);
        session.sendMessage(new TextMessage("Polo2!"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        log.info("connection established2..."+session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        log.info("close connection... status2: "+status);
    }
}
