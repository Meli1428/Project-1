package com.niit.shoppingcartbackend.app1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.model.Product;

public class ProductTest {
	
	static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
			
			context=new AnnotationConfigApplicationContext();
			context.scan("com");
			context.refresh();
			ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
			Product product=(Product)context.getBean("product");
			product.setProd_name("Product name");
			productDAO.saveOrUpdate(product);

			System.out.println("product added");
		}
	}


