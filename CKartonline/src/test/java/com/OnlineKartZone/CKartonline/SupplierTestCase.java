package com.OnlineKartZone.CKartonline;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

import com.OnlineKartZone.CKartonline.Dao.SupplierDao;
import com.OnlineKartZone.CKartonline.Dao.SupplierDao;
import com.OnlineKartZone.CKartonline.Model.Supplier;
import com.OnlineKartZone.CKartonline.Model.Supplier;
public class SupplierTestCase 
{

		public static void main(String arg[])
		{
AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			
			context.scan("com.OnlineKartZone.CKartonline");
			
			context.refresh();
			
			
			SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
			
			/*
			Supplier supplier=new Supplier();
			
			supplier.setSname("Western");
			supplier.setSaddr("It includes the westren style clothes");

			supplierDao.insertUpdateSupplier(supplier);		
			System.out.println("Supplier Inserted");*/
			
			
			
			/*Supplier supplier=supplierDao.getSupplier(1);
			System.out.println("Supplier Name:"+supplier.getSname());
			System.out.println("Supplier Description:"+supplier.getSaddr());*/
			
			//Deletion TestCase
			/*Supplier supplier=SupplierDao.getSupplier(2);
			supplierDao.deleteSupplier(supplier);
			System.out.println("The Supplier Deleted");
			*/
			
			List<Supplier> list=supplierDao.getSupplierDetails();
			
			for(Supplier supplier:list)
			{
				System.out.println(supplier.getSupid()+":"+supplier.getSname()+":"+supplier.getSaddr());
			}
			
			/*//Update the Supplier
			Supplier supplier=supplierDao.getSupplier(1);
			supplier.setSname("Anuj");
			supplierDao.insertUpdateSupplier(supplier);
			System.out.println("The Supplier Updated");*/
			
		
		}
}