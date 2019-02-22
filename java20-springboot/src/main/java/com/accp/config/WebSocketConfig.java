package com.accp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurationSupport;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.accp.handler.MyWebSocketHandler;
import com.accp.interceptor.MyInterceptor;

@Configuration
public class WebSocketConfig extends WebSocketConfigurationSupport {
	
	
	/**
	 * 注册websocket
	 */
	@Override
	protected void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//webSocketHandler ：消息或者用户的适配
		//paths ：注册的websocket地址，也就是用户的消息通信地址
		//interceptors : 拦截器，但是用于注册用户时配置的规则
		registry.addHandler(new MyWebSocketHandler(), "/mywebsocket").setAllowedOrigins("*").addInterceptors(new MyInterceptor());
	}

}
