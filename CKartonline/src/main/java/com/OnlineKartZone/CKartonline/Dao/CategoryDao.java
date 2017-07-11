package com.OnlineKartZone.CKartonline.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.OnlineKartZone.CKartonline.Model.*;

@Repository("categoryDao")
public class CategoryDao

{
		@Autowired
		SessionFactory sessionFactory;
		
		public CategoryDao(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		@Transactional
		public void insertUpdateCategory(Category category)
		{
			Session session=sessionFactory.getCurrentSession();            //insert
			session.saveOrUpdate(category);

		}
		
		public Category getCategory(int catid)
		{
			Session session=sessionFactory.openSession();
			Category category=(Category)session.get(Category.class,catid);	//specific retrieve
			session.close();
			return category;
		}
		
		@Transactional
		public void deleteCategory(Category category)
		{
			sessionFactory.getCurrentSession().delete(category);		//delete
		}
		
		public List<Category> getCategoryDetails()
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Category");		//retrieve in list
			List<Category> list=query.list();
			session.close();
			return list;
		}
		
	}

