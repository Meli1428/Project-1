package com.niit.shoppingcartbackend.app1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.model.User;

public class UserTest {

	static AnnotationConfigApplicationContext context;
	public static void main(String[] args) {
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		/*UserDAO userDAO=(UserDAO)context.getBean("userDAO");
		User user=(User)context.getBean("user");
		user.setUsername("Melinda");
		user.setEmailid("mm@yahoo.com");
		user.setConfirmpassword("1234");
		user.setEnabled("true");
		user.setPassword("1234");
		user.setPhno("12345");
		user.setRole("ROLE_ADMIN");
		userDAO.saveOrUpdate(user);
		System.out.println("user added");*/
	}

}
