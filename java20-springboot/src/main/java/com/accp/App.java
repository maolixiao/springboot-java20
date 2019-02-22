package com.accp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * 项目生命周期
 * 1、编译  compile
 * 2、测试 test
 * 3、打包  package
 * 4、部署 install
 * 5、发布 deploy
 * 6、运行
 * 
 * 
 * 
 *  控制层单元测试：
 * 
 * 
 * 
 * 
 * 
 * @author admin
 *
 */




@SpringBootApplication
@EnableCaching //开启缓存
@EnableWebSocket //开启web socket通信
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
