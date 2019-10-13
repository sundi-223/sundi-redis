package com.sundi;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:redis.xml")
public class ListTest {

	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")//去掉黄线警告
	@Test
	public void testRedisList() {
		ArrayList<Types> list = new ArrayList<Types>();
		
		
		Types types1 = new Types(101,"张三");
		Types types2 = new Types(102,"李四");
		Types types3 = new Types(103,"王五");
		
		list.add(types1);
		list.add(types2);
		list.add(types3);
		
		//使用模板对象
		//redisTemplate.opsForList().leftPush("mylist", list);
		
		//使用模板对象取值
		List<Types> list1 = (List<Types>) redisTemplate.opsForList().range("mylist", 0, -1);
		//rightPop会将数据库里的mylist删除
		//redisTemplate.opsForList().rightPop("mylist",0,-1);
		
		//遍历list1
		for (Object object : list1) {
			System.out.println(object);
		}
		
	}
}
