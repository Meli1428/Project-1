package com.niit.shoppingbackend.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.model.User;


@Repository(value="userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO{

		public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

		@Autowired
		private SessionFactory sessionfactory;
		
		
		//how get initialize
		//at the time
		public boolean isValid(String id, String password) {
			
			
			return false;
		}
		@Transactional
		public boolean saveOrUpdate(User user) {
			
			try
			{
				Session s=sessionfactory.getCurrentSession();
				Transaction tx=s.beginTransaction();
				//sessionfactory.getCurrentSession().saveOrUpdate(user);
				s.saveOrUpdate(user);
				tx.commit();

			}catch(Exception e)
			{
				e.printStackTrace();                                              
				return false;
			}
			return true;
		}

		public boolean delete(User user) {
			// TODO Auto-generated method stub
			return false;
		}

		

		public List<User> list() {
			@SuppressWarnings("unchecked")
			List<User>list=(List<User>)sessionfactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
		}

		public UserDAOImpl(SessionFactory sessionfactory) {
			super();
			this.sessionfactory = sessionfactory;
		}

		public User get(String email) {
			return (User) sessionfactory.getCurrentSession().get(User.class,email);
			//return null;
		}
		
	}
