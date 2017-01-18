package com.niit.shoppingbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingbackend.model.Product;


public class ProductDAOImpl implements ProductDAO

{
	
	public ProductDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	SessionFactory sessionfactory;

	public ProductDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	public Product getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(Product product) {
		Session s=sessionfactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(product);
		tx.commit();		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public Product get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
