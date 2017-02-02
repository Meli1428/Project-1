package com.niit.shoppingback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.model.Supplier;


public class SupplierTest {

		static AnnotationConfigApplicationContext context;
		public static void main(String[] args) {
			
			context=new AnnotationConfigApplicationContext();
			context.scan("com");
			context.refresh();
			SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
			Supplier supplier=(Supplier)context.getBean("supplier");
			/*supplier.setSupaddress("supplier address");
			supplier.setSupdescription("supplier des");
			supplier.setSupname("supplier name");
			supplierDAO.saveOrUpdate(supplier);*/
			System.out.println("supplier added");
		

	}

}
