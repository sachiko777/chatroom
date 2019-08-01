package com.webchat.webSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Component
@Configuration
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer { 
	private static final long heartbeatTime =  60000L; // 1 minute

    @Autowired
    MyHandler handler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //添加websocket处理器，添加握手拦截器
    	registry.addHandler(handler, "/ws").addInterceptors(new MyHandshakeInterceptor());
        //添加websocket处理器，添加握手拦截器
    	registry.addHandler(handler, "/ws/sockjs").addInterceptors(new MyHandshakeInterceptor())
    		.withSockJS().setHeartbeatTime(heartbeatTime);
    }


}