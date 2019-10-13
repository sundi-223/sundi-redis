package com.sundi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:redis.xml")
public class SetTest {

	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")//去掉黄线警告
	@Test
	public void testRedisSet() {		
		
		Types types1 = new Types(101,"大明");
		Types types2 = new Types(102,"二明");
		Types types3 = new Types(103,"三明");
		
		
		//使用模板对象
		redisTemplate.opsForSet().add("myset", types1,types2,types3);
		
		//使用模板对象查询
		Set set = redisTemplate.opsForSet().members("myset");
		
		//遍历set集合
		for (Object object : set) {
			System.out.println(object);
		}
	}
}
