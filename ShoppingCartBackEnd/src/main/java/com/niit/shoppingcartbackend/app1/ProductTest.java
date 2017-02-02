package com.niit.shoppingback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.model.Product;


public class ProductTest {
	
	static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
			
			context=new AnnotationConfigApplicationContext();
			context.scan("com");
			context.refresh();
			ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
			Product product=(Product)context.getBean("product");
			product.setProd_name("Product name");
			product.setProd_price(1);
			product.setQuantity(1);
			productDAO.saveOrUpdate(product);

			System.out.println("product added");
		}
	}


