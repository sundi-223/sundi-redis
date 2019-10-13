package com.sundi;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:redis.xml")
public class JsonTest {

	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")//去掉黄线警告
	@Test
	public void testRedisJson() {
	
		Types types1 = new Types(101,"杰森");
		
		String jsonString = JSON.toJSONString(types1);
		//System.out.println(jsonString);
		redisTemplate.opsForValue().set("jsonString", jsonString);
		String redisJson = (String) redisTemplate.opsForValue().get("jsonString");
		System.out.println(redisJson);
	}
}
