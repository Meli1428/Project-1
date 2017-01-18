package com.niit.shoppingbackend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingbackend.model.Category;



@Repository(value="categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {
	
	public CategoryDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SessionFactory sessionfactory;

	public List<Category> list() {
		@SuppressWarnings("unchecked")
		Session s=sessionfactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		List<Category>list=(List<Category>)s.createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		t.commit(); 
		return list;
	}

	public CategoryDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	public Category getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(Category category) {
		Session s=sessionfactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(category);
		tx.commit();

  		
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public Category get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
