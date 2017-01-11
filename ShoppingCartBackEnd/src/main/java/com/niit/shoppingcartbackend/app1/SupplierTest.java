package com.niit.shoppingcartbackend.app1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.model.Supplier;

public class SupplierTest {

		static AnnotationConfigApplicationContext context;
		public static void main(String[] args) {
			
			context=new AnnotationConfigApplicationContext();
			context.scan("com");
			context.refresh();
			SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
			Supplier supplier=(Supplier)context.getBean("supplier");
			supplier.setSupaddress("supplier address");
			supplier.setSupdescription("supplier des");
			supplier.setSupname("supplier name");
			supplierDAO.saveOrUpdate(supplier);
			System.out.println("supplier added");
		

	}

}
