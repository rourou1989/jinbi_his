package com.his.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.his.dao.UserDao;
import com.his.model.User;

public class TestSelectUsers {

	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)ctx.getBean("userDao");

		List<User> users= userDao.findByCondition("id > 4");
//		System.out.print("size -- " +users.size());
		for(User u : users){
			System.out.println(u.getUsername());
		}
	}

}
