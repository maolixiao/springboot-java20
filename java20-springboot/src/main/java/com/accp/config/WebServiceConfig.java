package com.accp.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accp.webservice.MyWebService;

@Configuration
public class WebServiceConfig {
	
	@Autowired
	Bus bus;
	
	@Autowired
	MyWebService mywebservice;
	
	/**
	 * 
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean registerWebService() {
		//默认名称为：service
		return new ServletRegistrationBean(new CXFServlet(), "/mywebservice/*");
	}
	
	/**
	 * 配置能访问的端点
	 * @return
	 */
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpointImpl = new EndpointImpl(bus);
		endpointImpl.publish("/myabc", mywebservice);
		return endpointImpl;
	}
	
	
}
