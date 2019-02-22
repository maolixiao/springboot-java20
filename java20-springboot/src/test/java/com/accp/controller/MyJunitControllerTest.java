package com.accp.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accp.domain.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * HttpClient
 * 
 * WebSocket
 * 
 * WebService
 * 
 * 
 * @author admin
 *
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyJunitControllerTest {
	
	MockMvc mock;
	/**
	 * web 容器 上下文对象
	 */
	@Autowired
	WebApplicationContext ctx;
	@Before
	public void before() {
		//根据上下文对象模拟请求（mock对象）
		mock = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Test
	@Ignore
	public void testView() {
		//定义请求
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/query");
		try {
			request.param("name", "唐勇");
			request.param("id","18");
			//发送请求
			ResultActions action = mock.perform(request);
			//验证返回逻辑视图是否为。。。。。。
//			MockMvcResultMatchers.status();//200
			ResultMatcher matcher = MockMvcResultMatchers.view().name("student/query");
			action.andExpect(matcher);
			//验证你model数据中是否有stus对象
			ResultMatcher matcher1 = MockMvcResultMatchers.model().attributeExists("stus");
			action.andExpect(matcher1);
			//验证你model数据中是否有name并且是否值为唐勇
			ResultMatcher matcher2 = MockMvcResultMatchers.model().attribute("name","唐勇");
			action.andExpect(matcher2);
			action.andDo(MockMvcResultHandlers.print());
			action.andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testJson() {
		//定义请求
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/json");
		try {
			request.param("name", "唐勇");
			request.param("id","18");
			//发送请求
			ResultActions action = mock.perform(request);
//			ResultMatcher ma =MockMvcResultMatchers.jsonPath("$[0].name", "混蛋1");
			//验证返回的json数据中是否有某一个指定的数据
			action.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").exists());
			MvcResult result = action.andReturn();
			//将响应结果内容通过字符串输出
			System.out.println(result.getResponse().getContentAsString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testJsonRequestBody() {
		//定义请求
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/jsonRequestBody");
		try {
			
//			String str = "{\"name\":11,id:11}";
			Student stu = new Student(11,"老谭");
			request.contentType(MediaType.APPLICATION_JSON_UTF8);
			
			//将对象转换成json字符串
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(stu);
			
			
			//将字符串转换成对象
			Student sjson = mapper.readValue(json, Student.class);
			
			//将字符串转换成list
			String json2 = "[{\"id\":\"1\",\"name\":\"2\"},{\"id\":\"2\",\"name\":\"1\"}]";
			List<Student> stulist = mapper.readValue(json2,new TypeReference<Student>() {
			});
			
			
			request.content(json);
			//发送请求
			ResultActions action = mock.perform(request);
//					ResultMatcher ma =MockMvcResultMatchers.jsonPath("$[0].name", "混蛋1");
			//验证返回的json数据中是否有某一个指定的数据
			action.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").exists());
			MvcResult result = action.andReturn();
			//将响应结果内容通过字符串输出
			System.out.println(result.getResponse().getContentAsString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
