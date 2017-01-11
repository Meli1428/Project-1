package com.niit.shoppingcartbackend.app1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.model.Category;

public class CategoryTest {

	static AnnotationConfigApplicationContext context;
	public static void main(String[] args) {
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		Category category=(Category)context.getBean("category");
		category.setCatdescription("cat description");
		category.setCatname("cat name");
		categoryDAO.saveOrUpdate(category);
		System.out.println("cat added");
	}

}
