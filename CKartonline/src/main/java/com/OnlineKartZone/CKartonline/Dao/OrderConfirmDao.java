package com.OnlineKartZone.CKartonline.Dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.OnlineKartZone.CKartonline.Model.*;
@Repository("orderconfirmDao")
public class OrderConfirmDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderConfirmDao(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateOrder(OrderConfirm orderconfirm)
	{
		Session session=sessionFactory.getCurrentSession();            //insert
		session.saveOrUpdate(orderconfirm);

	}
	public List<OrderConfirm> getOrderDetails(String uname ,int orderid)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from OrderConfirm where uname='"+uname+"' and orderid="+orderid);//retrieve in list
		List<OrderConfirm> list=query.list();
		session.close();
		return list;
	}

	public int getorderid(String uname)		//max orderid
	{
		Session session=sessionFactory.openSession();
		Query query2=session.createQuery("select max(orderid) from OrderConfirm where uname='"+uname+"'");
		int orderid=(int) query2.list().get(0);
		System.out.println(orderid);
		return orderid+1;
	}
	
	public OrderConfirm getorder()					//retrive in list
	{
		Session session=sessionFactory.openSession();
		Query query1=session.createQuery("from OrderConfirm order by orderid asc");
		List<OrderConfirm> list1=query1.list();
		session.close();
		if(list1.size()>0)
		{
			return list1.get(0);
			
		}
		else
		{
			System.out.println("Invalid");
		}
		return null;
		
		
	}
}
