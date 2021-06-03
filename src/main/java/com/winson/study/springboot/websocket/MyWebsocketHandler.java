package com.winson.study.springboot.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PingMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

/**
 * @author winson
 * @date 2021/6/2
 **/
public class MyWebsocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        System.out.println("after session closed , session is : " + session);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println("after session establish , session is : " + session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        super.handleTextMessage(session, message);
        System.out.println("handle text message ... " + message.getPayload());
        TextMessage response = new TextMessage("服务端返回消息：" + message.getPayload());
        session.sendMessage(response);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        session.sendMessage(new PingMessage());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println("complete ping message ... ");
//            }
//        }).start();
    }

}
