package com.accp.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component
public class MyWebSocketHandler extends TextWebSocketHandler {
	
	/**
	 * key : 在interceptor中拦截的用户编号
	 * 
	 * WebSocketSession：当前编号对应的session会话对象
	 */
	static Map<String, WebSocketSession> MAP = new HashMap<String,WebSocketSession>();
	
	
	
	/**
	 * 获取连接
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//获取拦截器中注册进去的uid值
		String uid = session.getAttributes().get("uid")+"";
		if(uid!=null) {
			MAP.put(uid, session);
			System.out.println("连接成功......");
			session.sendMessage(new TextMessage("你已经可以与服务器通信连接成功."));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}
	
	
	public String sendMsg(String uid,String msg) {
		WebSocketSession session = MAP.get(uid);
		if(session==null) {
			return "没有登陆";
		}
		try {
			session.sendMessage(new TextMessage(msg));
			return "000001";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "000000";
		}
	}

}
