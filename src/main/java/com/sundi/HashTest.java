package com.sundi;

import java.util.HashMap;
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
public class HashTest {

	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")//去掉黄线警告
	@Test
	public void testRedisHash() {
		Map<String,Types> map = new HashMap<String,Types>();
		
		
		Types types1 = new Types(101,"大傻");
		Types types2 = new Types(102,"二傻");
		Types types3 = new Types(103,"三傻");
		
		map.put("1", types1);
		map.put("2", types2);
		map.put("3", types3);
		
		//使用模板对象
		redisTemplate.opsForHash().putAll("myhash", map);
		
		//使用模板对象查询
		Map myhash = redisTemplate.opsForHash().entries("myhash");
		
		//使用entrySet遍历Map集合
		Set entrySet = myhash.entrySet();
		
		for (Object object : entrySet) {
			System.out.println(object);
		}
	}
}
