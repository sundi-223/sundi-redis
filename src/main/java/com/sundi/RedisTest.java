package com.sundi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:redis.xml")
public class RedisTest {

	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	@Test
	public void testRedis() {
		//redisTemplate.opsForValue().set("1705E", "sundi");
		redisTemplate.opsForValue().append("1705E", "SPY");
		
		String value = redisTemplate.opsForValue().get("1705E");
		System.out.println(value);
	}
}
