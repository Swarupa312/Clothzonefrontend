package com.OnlineKartZone.CKartonline.Dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.OnlineKartZone.CKartonline.Model.*;

@Repository("userDao")
public class UserDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDao(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateUser(User user)
	{
		Session session=sessionFactory.getCurrentSession();            //insert
		session.saveOrUpdate(user);

	}
	
	public User getUser(String uname)
	{
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,uname);	//specific retrieve
		session.close();
		return user;
	}
	
	@Transactional
	public void deleteUser(User user)
	{
		sessionFactory.getCurrentSession().delete(user);		//delete
	}
	
	public List<User> getUserDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");		//retrieve in list
		List<User> list=query.list();
		
		session.close();
		return list;
	}

}