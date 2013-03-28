package com.his.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.his.dao.UserDao;
import com.his.model.User;
import com.his.util.Encript;

public class TestCreateUser {
	public static void main(String[] args){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)ctx.getBean("userDao");
		User user =  new User();
		
		
		user.setUsername("张三");
		user.setPassword(Encript.md5("ABC"));
		int result = userDao.create(user);
		System.out.println("ok" + result);
		
	}
}
