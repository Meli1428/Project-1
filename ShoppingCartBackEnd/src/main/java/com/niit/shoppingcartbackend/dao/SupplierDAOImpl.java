package com.niit.shoppingbackend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingbackend.model.Supplier;


@Repository(value="supplierDAO")
@EnableTransactionManagement

public class SupplierDAOImpl implements SupplierDAO {
	
	public SupplierDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Autowired
	private SessionFactory sessionfactory;

	public Supplier getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void saveOrUpdate(Supplier supplier) {

		Session s=sessionfactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(supplier);
		tx.commit();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public Supplier get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		Session s=sessionfactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		List<Supplier>list=(List<Supplier>)s.createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		t.commit();
		return list;		
	}


	public SupplierDAOImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}
	

}
