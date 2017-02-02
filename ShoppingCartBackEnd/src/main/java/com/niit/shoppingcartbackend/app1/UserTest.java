package com.niit.shoppingback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.model.User;


public class UserTest {

	static AnnotationConfigApplicationContext context;
	public static void main(String[] args) {
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		UserDAO userDAO=(UserDAO)context.getBean("userDAO");
		User user=(User)context.getBean("user");
		//user.setUser_id(100);
		/*user.setUsername("Melinda");
		user.setEmailid("mm@yahoo.com");
		user.setConfirmpassword("1234");
		user.setEnabled("true");
		user.setPassword("1234");
		user.setPhno("12345");
		user.setRole("ROLE_USER");
		userDAO.saveOrUpdate(user);
		System.out.println("user added");*/
	}

}
