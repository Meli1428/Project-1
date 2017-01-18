package com.niit.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.CategoryDAOImpl;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.ProductDAOImpl;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dao.SupplierDAOImpl;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dao.UserDAOImpl;
import com.niit.shoppingbackend.model.Category;
import com.niit.shoppingbackend.model.Product;
import com.niit.shoppingbackend.model.Supplier;
import com.niit.shoppingbackend.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class ApplicationContextConfig
{
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/DT12");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("data source");
		return dataSource;
	}
	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update"); 
		properties.put("hibernate.current_session_context_class", "thread");
		System.out.println("hibernate properties");
		return properties;

	}

	
	@Autowired
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		
		/*sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		sessionBuilder.addAnnotatedClass(Customer.class);*/
		
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		System.out.println("session factory");
		return sessionBuilder.buildSessionFactory();

	}
	
	@Autowired
	@Bean(name= "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionfactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionfactory);
		System.out.println("transaction");
		return transactionManager;
	}
	
	//User
	
	@Autowired
	@Bean(name="UserDAO")
	public UserDAO getUserDAO(SessionFactory sessionfactory)
	{
		System.out.println("user dao wired ");
		return new UserDAOImpl(sessionfactory);
	}
		
	@Autowired
	@Bean(name="user")
	public User getUser()
	{
		System.out.println("user");
	
		return new User();
	}
	
	//Category
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionfactory)
	{
		System.out.println("user dao wired ");
		return new CategoryDAOImpl(sessionfactory);
	}
		
	@Autowired
	@Bean(name="category")
	public Category getCategory()
	{
		System.out.println("category");
	
		return new Category();
	}
	
	//Supplier
		@Autowired
		@Bean(name="supplierDAO")
		public SupplierDAO getSupplierDAO(SessionFactory sessionfactory)
		{
			System.out.println("supplier dao wired ");
			return new SupplierDAOImpl(sessionfactory);
		}
			
		@Autowired
		@Bean(name="supplier")
		public Supplier getSupplier()
		{
			System.out.println("supplier");
		
			return new Supplier();
		}
		@Autowired
		@Bean(name="productDAO")
		public ProductDAO getProductDAO(SessionFactory sessionfactory)
		{
			System.out.println("product dao wired ");
			return new ProductDAOImpl(sessionfactory);
		}
			
		@Autowired
		@Bean(name="product")
		public Product getProduct()
		{
			System.out.println("product");
		
			return new Product();
		}
	
}


