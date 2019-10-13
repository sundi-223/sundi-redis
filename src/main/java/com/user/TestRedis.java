package com.user;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:redis.xml")
public class TestRedis {

	@Autowired
	RedisTemplate redisTemplate;
	
	@Test
	public void test() {
		long start = System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			HashMap<String, User> map = new HashMap<String, User>();
			User u = new User();
			u.setId(i);
			u.setBirthday(UserUtils.getBirthday());
			u.setMail(UserUtils.getMail());
            u.setName(UserUtils.getName());
            u.setSex(UserUtils.getSex());
            u.setPhone(UserUtils.getPhone());
            map.put("user"+i,u);
            redisTemplate.opsForHash().putAll("user"+i,map);
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时:"+(end-start));
		System.out.println("保存数量是100000个");
		System.out.println("序列化方式是:hash");
	}
}
