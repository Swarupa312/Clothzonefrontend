package com.OnlineKartZone.CKartonline.Dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.OnlineKartZone.CKartonline.Model.*;

@Repository("productrDao")
public class ProductDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDao(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateProduct(Product product)
	{
		Session session=sessionFactory.getCurrentSession();            //insert
		session.saveOrUpdate(product);

	}
	public int getProdid()
	{
		Session session=sessionFactory.openSession();		//get Max product id
		String maxid="select max(prodid) from Product";
		
		Query query=session.createQuery(maxid);
		int prodid=(int) query.list().get(0);
		System.out.println(prodid);
		return prodid+1;
		
	}
	
	public Product getProduct(int prodid)				//get specific product
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,prodid);	//specific retrieve
		session.close();
		return product;
	}
	
	@Transactional
	public void deleteProduct(Product product)
	{
		sessionFactory.getCurrentSession().delete(product);		//delete
	}
	
	public List<Product> getProductDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");		//retreive in list
		List<Product> list=query.list();
		session.close();
		return list;
	}
	
	public List<Product> getproductbyCatid(int catid)			//product by category
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where catid=:catid");
		query.setParameter("catid",catid);
		List<Product> list=query.list();
		session.close();
		return list;
	}
	
	public int reduceprod(int prodid,int prodqty)
	{
		
		Session session=sessionFactory.openSession();
		 Query query2=session.createQuery("select prodqty from Product where prodid="+prodid);
		int newqty=(int)query2.list().get(0)- prodqty;
		
		System.out.println(newqty);
		session.close();
		return newqty;
	}
	
	
	
	
	public boolean checkproductid(int prodid)
	{
		
		Session session=sessionFactory.openSession();
		Query query2=session.createQuery("from Cart where prodid="+prodid);
		if(query2.list().isEmpty())
		{
		return true;
		}
		else
		{
		return false;
		}
	}
	
	public List<Product> getproductbyname(String prodname)
	{
		Session session=sessionFactory.openSession();
		Query query2=session.createQuery("from Product where prodname='"+prodname+"'");
		List<Product> list=query2.list();
		
		return list;
	}

	
}
