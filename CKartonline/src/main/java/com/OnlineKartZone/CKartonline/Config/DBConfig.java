package com.OnlineKartZone.CKartonline.Config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.OnlineKartZone.CKartonline.Dao.CartDao;
import com.OnlineKartZone.CKartonline.Dao.CategoryDao;
import com.OnlineKartZone.CKartonline.Dao.OrderConfirmDao;
import com.OnlineKartZone.CKartonline.Dao.ProductDao;
import com.OnlineKartZone.CKartonline.Dao.SupplierDao;
import com.OnlineKartZone.CKartonline.Dao.UserDao;
import com.OnlineKartZone.CKartonline.Model.Cart;
import com.OnlineKartZone.CKartonline.Model.Category;
import com.OnlineKartZone.CKartonline.Model.OrderConfirm;
import com.OnlineKartZone.CKartonline.Model.Product;
import com.OnlineKartZone.CKartonline.Model.Supplier;
import com.OnlineKartZone.CKartonline.Model.User;

@Configuration
@ComponentScan("com.OnlineKartZone.CKartonline")
@EnableTransactionManagement

public class DBConfig 
{
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() 
	{
		System.out.println("Starting of the method getH2DataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("Data Source Creation");
		return dataSource;
	}

	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		System.out.println("---Hibernate Properties----");
		Properties prop=new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql", "true"); 
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		System.out.println("---Hibernate Properties Created");
		
		System.out.println("---Local SessionFactory Builder Object Creation---");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		sessionBuilder.addProperties(prop);
		System.out.println("---Factory Builder Object Created---");
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(OrderConfirm.class);
		System.out.println("Session Factory Object Creation");
		SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
		System.out.println("Session Factory Object Created");
		return sessionFactory;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("--Transaction manager Object Creation--");
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		System.out.println("--Transaction manager Object Created--");
		return transactionManager;
	}
	@Autowired
	@Bean(name="categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory)
	{
		System.out.println("-- CategoryDao Object Creation--");
		return new CategoryDao(sessionFactory);
	}
	
	@Autowired
	@Bean(name="supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory)
	{
		System.out.println("-- SupplierDao Object Creation--");
		return new SupplierDao(sessionFactory);
	}
	
	@Autowired
	@Bean(name="userDao")
	public UserDao getUserDao(SessionFactory sessionFactory)
	{
		System.out.println("-- UserDao Object Creation--");
		return new UserDao(sessionFactory);
	}
	
	@Autowired
	@Bean(name="productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory)
	{
		System.out.println("-- ProductDao Object Creation--");
		return new ProductDao(sessionFactory);
	}
	
	@Autowired
	@Bean(name="cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory)
	{
		System.out.println("-- CartDao Object Creation--");
		return new CartDao(sessionFactory);
	}
	
	@Autowired
	@Bean(name="orderconfirmDao")
	public OrderConfirmDao getorders(SessionFactory sessionFactory)
	{
		System.out.println("-- orderconfirm Dao Object Creation--");
		return new OrderConfirmDao(sessionFactory);
	}
}
