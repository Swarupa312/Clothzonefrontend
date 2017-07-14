package com.OnlineKartZone.CKartonline.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.OnlineKartZone.CKartonline.Model.*;

@Repository("cartDao")
public class CartDao 

{
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDao(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateCart(Cart cart)
	{
		Session session=sessionFactory.getCurrentSession();            //insert
		session.saveOrUpdate(cart);

	}
	
	public Cart getCart(int cartitemid)
	{
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class,cartitemid);	//specific retrieve
		session.close();
		return cart;
	}
	
	@Transactional
	public void deleteCart(Cart cart)
	{
		sessionFactory.getCurrentSession().delete(cart);		//delete
	}
	
	@Transactional
	public void updatecart(Cart cart)
	{
		sessionFactory.getCurrentSession().update(cart);
	}
	
	public List<Cart> getCartDetails(String uname)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where uname=:uname");//retrieve in list
		query.setParameter("uname", uname);
		List<Cart> list=query.list();
		session.close();
		return list;
	}
	 public int getCartid(String uname)						//get cart id 
	 {
		 	Session session=sessionFactory.openSession();
			Query query1=session.createQuery("select cartid from Cart where uname='"+uname+"'");
			if(query1.list().size()==0)
			{
				Query query2=session.createQuery("select max(cartid) from Cart");
				int cartid=(int)query2.list().get(0);
				return cartid+1;
			
			}
			else
			{
				int cartid=(int) query1.list().get(0);
				System.out.println(cartid);
				return cartid;
			}
	 }
	 public Cart checkprodid(String uname,int prodid)
	 {
		 Session session=sessionFactory.openSession();
		 Query query2=session.createQuery("from Cart where uname='"+uname+"' and prodid="+prodid);
		 System.out.println(query2.list().size());
		 if(query2.list().size()!=0)
		 {
			 Cart cart=(Cart)query2.list().get(0);
			 return cart;
		 }
		  return null;
		
	 }
	 @Transactional
	 public int  increamentqty(int prodqty,String uname,int prodid)
	 {
		 Session session=sessionFactory.openSession();
		 Query query2=session.createQuery("select prodqty from Cart where uname='"+uname+"' and prodid="+prodid);
		 System.out.println(query2.list().size());
		  int prodqtyi=prodqty+(int)query2.list().get(0);
		  return prodqtyi;	 
	 }
	 
	 public Cart getcartdetails(int cartitemid)
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Cart where cartitemid="+cartitemid);//retrieve in list
			Cart cart=(Cart)query.list().get(0);
			session.close();
			return cart;
		}
	 

}
