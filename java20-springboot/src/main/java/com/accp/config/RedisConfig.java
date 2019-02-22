package com.accp.config;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {
	/**
	 * 注入redis的连接工厂
	 */
	@Autowired
	RedisConnectionFactory redisConnectionFactory;
	
	
	/**
	 * 自定义key
	 */
	@Bean
	public KeyGenerator keyGenerator() {
		// TODO Auto-generated method stub
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuffer bf = new StringBuffer();
				bf.append(target.getClass().getName());
				bf.append(method.getName());
				for(Object obj : params) {
					bf.append(obj.toString());
				}
				return bf.toString();
			}
		};
	}

	/**
	 * 配置缓存管理器
	 */
	@Bean
	public CacheManager cacheManager() {
		// 获取redis的默认配置对象
		RedisCacheConfiguration config = 
				RedisCacheConfiguration.defaultCacheConfig()
				.serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
		config.entryTtl(Duration.ofHours(20));
		// 改变redis中缓存key的存储序列化
//		config.serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()));
		// 改变redis中缓存value的存储序列化为json格式
//		config.serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
		// 禁用空值缓存
		// config.disableCachingNullValues();
		CacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory).transactionAware()
				.cacheDefaults(config).build();
		return cacheManager;
	}
}
