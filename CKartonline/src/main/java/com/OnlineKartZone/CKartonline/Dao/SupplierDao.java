package com.OnlineKartZone.CKartonline.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.OnlineKartZone.CKartonline.Model.*;

@Repository("supplierDao")
public class SupplierDao

{
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDao(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateSupplier(Supplier supplier)
	{
		Session session=sessionFactory.getCurrentSession();            //insert
		session.saveOrUpdate(supplier);

	}
	
	public Supplier getSupplier(int supid)
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supid);	//specific retrieve
		session.close();
		return supplier;
	}
	
	@Transactional
	public void deleteSupplier(Supplier supplier)
	{
		sessionFactory.getCurrentSession().delete(supplier);		//delete
	}
	
	public List<Supplier> getSupplierDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");		//retrieve in list
		List<Supplier> list=query.list();
		session.close();
		return list;
	}
	}

