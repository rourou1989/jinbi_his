package com.his.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.his.dao.UserDao;
import com.his.model.User;

public class TestSelectUser {

	@Test
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)ctx.getBean("userDao");
		
		//通过id 查询用户
		User user = userDao.findById(4);
		System.out.println("ok" + user.getUsername());
	}

}
