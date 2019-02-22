package com.accp.interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.accp.domain.Student;

public class MyInterceptor implements HandshakeInterceptor {

	/**
	 * 定义用于注册在websocket中的规则
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		/**
		 * 将用户的编号作为唯一标识，用于区分哪个用户与用户之间通信
		 */
		ServletServerHttpRequest servletRequest = (ServletServerHttpRequest)request;
		HttpSession session = servletRequest.getServletRequest().getSession();
		Student stu = (Student)session.getAttribute("user");
		if(session.getAttribute("user")!=null) {
			int uid = stu.getId();
			attributes.put("uid", uid);
			return true;
		}
		return false;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		
	}
}
